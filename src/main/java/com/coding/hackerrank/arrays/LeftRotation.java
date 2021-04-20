package com.coding.hackerrank.arrays;

import java.util.Arrays;

public class LeftRotation {

    static int[] rotLeft(int[] a, int d) {
        if (d == 0 || a == null || a.length == 0) {
            return a;
        }

        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[(i + d) % a.length];
        }
        return b;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotLeft(arr, 1)));
    }
}
