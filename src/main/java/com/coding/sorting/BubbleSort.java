package com.coding.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 7, 1, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Sorting process
     * Compare two items.
     * If the one on the left is bigger, swap them.
     * Move one position right.
     */
    public static void sort(int[] arr) {
        for (int reverseIndex = arr.length - 1; reverseIndex > 1; reverseIndex--) {
            for (int i = 0; i < reverseIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}
