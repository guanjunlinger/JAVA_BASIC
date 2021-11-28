package com.algorithm.dp;

import java.util.Scanner;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = n * nums[i];
            sum += nums[i];
        }
        int ave = sum / n;
        return dfs(0, ave, 0, nums, 0);
    }

    public boolean dfs(int state, int ave, int total, int[] nums, int currentSum) {
        if (total > 0 && total < nums.length / 2 && total * ave == currentSum) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((state & (1 << i)) == 0) {
                if (dfs(state | (1 << i), ave, total + 1, nums, currentSum + nums[i])) {
                    return true;
                }
            }

        }
        return false;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution.splitArraySameAverage(arr));
    }
}