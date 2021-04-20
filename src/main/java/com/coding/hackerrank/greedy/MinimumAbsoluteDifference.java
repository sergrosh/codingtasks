package com.coding.hackerrank.greedy;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Math.abs(arr[0] - arr[1]);
        for (int i = 2; i < arr.length; i++) {
            min = Math.min(Math.abs(arr[i] - arr[i - 1]), min);
        }
        return min;
    }
}
