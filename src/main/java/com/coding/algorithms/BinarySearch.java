package com.coding.algorithms;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 7, 9, 11, 15};
        System.out.println("Index of 5 is " + search(arr, 5));
    }

    public static int search(int[] arr, int value) {
        return search(arr, value, 0, arr.length - 1);
    }

    private static int search(int[] arr, int value, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] > value) {
            return search(arr, value, start, mid - 1);
        } else if (arr[mid] < value) {
            return search(arr, value, mid + 1, end);
        } else {
            return mid;
        }

    }
}
