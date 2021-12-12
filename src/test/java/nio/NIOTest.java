package nio;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.*;

import java.nio.file.StandardWatchEventKinds;

public class NIOTest {

    @Test
    public void testFileVisitor() throws IOException {
        Path path = Paths.get("/Users/guanjun/gitrepository/graph");
        Files.walkFileTree(path, new CustomFileVisitor());

    }

    @Test
    public void testWatchService() throws IOException {
        Path path = Paths.get("/Users/guanjun/gitrepository/graph");
        WatchService watcher = FileSystems.getDefault().newWatchService();
        WatchKey temp = path.register(watcher,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        for (; ; ) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }

                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();
                if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println(filename + " 被修改");
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.println(filename + " 被删除");
                } else {
                    System.out.println(filename + " 被创建");
                }
            }
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }

}
