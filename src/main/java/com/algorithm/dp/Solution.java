package com.algorithm.dp;


import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private HashMap<Integer, Boolean> map = new HashMap<>();

    public boolean canIWin(int max, int desired) {
        int sum = (1 + max) * max / 2;
        if (sum < desired) return false;
        if (desired <= 0) return true;
        return canIWin(max, desired, 0);
    }

    private boolean canIWin(int max, int desired, int state) {
        if (desired <= 0) {
            return false;
        }
        if (map.containsKey(state)) return map.get(state);
        for (int i = 1; i <= max; i++) {
            if (((1 << (i - 1)) & state) == 0) {
                boolean win = canIWin(max, desired - i, state | (1 << i - 1));
                if (!win) {
                    map.put(state, true);
                    return true;
                }

            }
        }
        map.put(state, false);
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int max = scanner.nextInt();
        int desire = scanner.nextInt();
        System.out.println(solution.canIWin(max, desire));
    }
}