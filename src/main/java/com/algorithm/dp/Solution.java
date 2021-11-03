package com.algorithm.dp;

import java.util.Scanner;

public class Solution {
    public static int maxSumAfterPartitioning(int[] arr, int k) {




    return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(maxSumAfterPartitioning(array,3));
    }

}
