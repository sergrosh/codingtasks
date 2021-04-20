package com.coding.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 6, 5, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int array[]) {
        quickSort(array, 0, array.length - 1);
    }

    /*
     * The quickSort algorithm implementation
     */
    private void quickSort(int array[], int startIndex, int endIndex) {

        // check that there are at least two elements to sort
        // if there is only one element in the partition, do not do any sorting
        if (endIndex - startIndex >= 1) {
            int rightIndex = partition(array, startIndex, endIndex);

            // quicksort the left partition
            quickSort(array, startIndex, rightIndex - 1);

            // quicksort the right partition
            quickSort(array, rightIndex + 1, endIndex);
        }
    }

    private int partition(int array[], int startIndex, int endIndex) {
        // index of left-to-right scan
        int leftIndex = startIndex;

        // index of right-to-left scan
        int rightIndex = endIndex;

        // set the pivot as the first element in the partition
        int pivot = array[startIndex];

        // while the scan indices from left and right have not met
        while (rightIndex > leftIndex) {

            // from the left, look for the first
            // element greater than the pivot
            while (array[leftIndex] <= pivot && leftIndex <= endIndex && rightIndex > leftIndex) {
                leftIndex++;
            }

            // from the right, look for the first
            // element not greater than the pivot
            while (array[rightIndex] > pivot && rightIndex >= startIndex && rightIndex >= leftIndex) {
                rightIndex--;
            }

            // if the left seekindex is still smaller than
            // the right index, swap the corresponding elements
            if (rightIndex > leftIndex) {
                swap(array, leftIndex, rightIndex);
            }
        }

        // after the indices have crossed, swap the last element in
        // the left partition with the pivot
        swap(array, startIndex, rightIndex);

        return rightIndex;
    }

    private void swap(int array[], int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
