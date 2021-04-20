package com.coding.sorting;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 7, 5, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /*
     * The mergeSort algorithm implementation
     */
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // split the array into 2
            int center = (left + right) / 2;
            // sort the left and right array
            mergeSort(array, left, center);
            mergeSort(array, center + 1, right);
            // merge the result
            merge(array, left, center + 1, right);
        }
    }

    /*
     * The merge method used by the mergeSort algorithm implementation.
     */
    private void merge(int[] array, int leftArrayBegin,
                       int rightArrayBegin, int rightArrayEnd) {
        int leftArrayEnd = rightArrayBegin - 1;

        int numElements = rightArrayEnd - leftArrayBegin + 1;
        int[] resultArray = new int[numElements];
        int resultArrayBegin = 0;

        while (leftArrayBegin <= leftArrayEnd && rightArrayBegin <= rightArrayEnd) {

            if (array[leftArrayBegin] <= array[rightArrayBegin]) {
                resultArray[resultArrayBegin++] = array[leftArrayBegin++];
            } else {
                resultArray[resultArrayBegin++] = array[rightArrayBegin++];
            }
        }

        // After the main loop completed we may have few more elements in
        // left array copy them first
        while (leftArrayBegin <= leftArrayEnd) {

            resultArray[resultArrayBegin++] = array[leftArrayBegin++];
        }

        // After the main loop completed we may have few more elements in
        // right array copy them
        while (rightArrayBegin <= rightArrayEnd) {

            resultArray[resultArrayBegin++] = array[rightArrayBegin++];
        }

        // Copy resultArray back to the main array
        for (int i = numElements - 1; i >= 0; i--, rightArrayEnd--) {
            array[rightArrayEnd] = resultArray[i];
        }
    }
}
