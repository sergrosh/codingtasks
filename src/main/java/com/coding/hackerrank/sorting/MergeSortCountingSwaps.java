package com.coding.hackerrank.sorting;

public class MergeSortCountingSwaps {

    public static void main(String[] args) {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 7, 5, 3};
        MergeSort mergeSort = new MergeSort();

        System.out.println(mergeSort.mergeSort(array));
    }


    private static class MergeSort {
        /* Our array has up to n = 100,000 elements. That means there may be O(n^2) swaps.
           n^2 is 10,000,000,000. A Java int has max value 2,147,483,647 so we use a long
           to avoid integer overflow */
        private long swaps = 0;

        public long mergeSort(int[] array) {
            int[] helper = new int[array.length];
            mergeSort(array, helper, 0, array.length - 1);
            return swaps;
        }

        private void mergeSort(int[] array, int[] helper, int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                mergeSort(array, helper, start, mid);
                mergeSort(array, helper, mid + 1, end);
                merge(array, helper, start, mid, end);
            }
        }

        private void merge(int[] array, int[] helper, int start, int mid, int end) {
            /* Fill helper array with same elements as original array */
            for (int i = start; i <= end; i++) { // notice "i" goes from "start" to "end", not "0" to "array.length"
                helper[i] = array[i];
            }

            int curr = start;
            int left = start;
            int right = mid + 1;

            /* Loop through helper[] left and right halves and continuously copy smaller element to array[] */
            while (left <= mid && right <= end) {
                if (helper[left] <= helper[right]) {
                    array[curr++] = helper[left++];
                } else {
                    /* Each time we choose element from right side, we count up how many elements
                       it is less than from left side. This is equivalent to counting swaps. */
                    swaps += mid + 1 - left;
                    array[curr++] = helper[right++];
                }
            }

            /* Copy remaining elements of left half. Right half elements are already in proper place */
            while (left <= mid) {
                array[curr++] = helper[left++];
            }
        }
    }
}
