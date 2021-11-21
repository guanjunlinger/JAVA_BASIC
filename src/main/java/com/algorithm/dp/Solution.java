package com.algorithm.dp;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    Set<Character> set = new HashSet();

    {
        set.add('a');
        set.add('o');
        set.add('e');
        set.add('i');
        set.add('u');
    }

    public boolean isVowel(char s) {
        return set.contains(s);
    }

    public long countVowels(String word) {
        int n = word.length();
        long[] dp = new long[n];
        if (isVowel(word.charAt(0))) {
            dp[0] = 1;
        }
        long sum = dp[0];
        for (int i = 1; i < n; i++) {
            if (isVowel(word.charAt(i))) {
                dp[i] = dp[i - 1] + i + 1;
            } else {
                dp[i] = dp[i - 1];
            }
            sum = sum + dp[i];

        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        String s = scanner.nextLine();
        System.out.println(solution.countVowels(s));
    }
}