package com.coding.sorting;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 6, 5, 3};
        QuickSort2 quickSort = new QuickSort2();
        quickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] arr, int startIndex, int endIndex) {
        if (endIndex - startIndex >= 1) {
            int rightIndex = partition(arr, startIndex, endIndex);

            quickSort(arr, startIndex, rightIndex - 1);
            quickSort(arr, rightIndex + 1, endIndex);
        }
    }

    private int partition(int[] arr, int startIndex, int endIndex) {
        int leftIndex = startIndex;
        int rightIndex = endIndex;
        int pivot = arr[startIndex];

        while (rightIndex > leftIndex) {

            while (arr[leftIndex] <= pivot && leftIndex <= endIndex && leftIndex < rightIndex) {
                leftIndex++;
            }

            while (arr[rightIndex] > pivot && rightIndex >= startIndex && rightIndex >= leftIndex) {
                rightIndex--;
            }

            if (rightIndex > leftIndex) {
                swap(arr, leftIndex, rightIndex);
            }
        }
        swap(arr, startIndex, rightIndex);
        return rightIndex;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
