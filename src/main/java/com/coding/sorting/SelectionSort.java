package com.coding.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 7, 1, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            int minIndex = findSmallestElementIndex(index, arr);
            int temp = arr[index];
            arr[index] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    private static int findSmallestElementIndex(int startIndex, int[] arr) {
        int minIndex = startIndex;
        int minElement = arr[startIndex];
        for (int index = startIndex; index < arr.length; index++) {
            if (minElement > arr[index]) {
                minElement = arr[index];
                minIndex = index;
            }
        }
        return minIndex;
    }
}
