package com;

import java.util.Scanner;

public class Solution {

    public static int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int mod = (int) Math.pow(10, 9) + 7;
        int[][] dp = new int[n][2];
        if ((arr[0] & 1) == 0) {
            dp[0][0] = 1;
        } else {
            dp[0][1] = 1;
        }
        int res = dp[0][1];
        for (int i = 1; i < n; i++) {
            if ((arr[i] & 1) == 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
            res += dp[i][1]%mod;
            res = res % mod;
        }
        return res;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(numOfSubarrays(arr));
    }

}
