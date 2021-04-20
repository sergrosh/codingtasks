package com.coding.hackerrank.greedy;

import java.util.Arrays;

public class LuckBalance {

    static int luckBalance(int k, int[][] contests) {
        int sum = 0;
        int skip = 0;
        Arrays.sort(contests, (t1, t2) -> Integer.compare(t2[0], t1[0]));
        for (int[] arr : contests) {
            if (arr[1] == 0) {
                sum += arr[0];
            } else {
                if (skip < k) {
                    sum += arr[0];
                    skip++;
                } else {
                    sum -= arr[0];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(luckBalance(3, new int[][]{{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}}));
    }
}
