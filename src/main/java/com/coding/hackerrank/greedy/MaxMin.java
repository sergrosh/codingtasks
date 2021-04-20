package com.coding.hackerrank.greedy;

import java.util.Arrays;

public class MaxMin {

    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= arr.length - k; i++)
            min = Math.min(min, arr[k + i - 1] - arr[i]);
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 100, 300, 200, 1000, 20, 30};
        System.out.println(maxMin(3, arr));
    }
}
