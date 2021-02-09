package com.coding.sorting;

import java.util.Arrays;

public class InsertionSort {


    public static void main(String[] args) {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 7, 5, 3};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int array[]) {
        // Ignore the first element [0]
        // start from the element [1] -- Get that element and insert
        for (int index = 1; index < array.length; index++) {
            insert(array, index);
        }
    }

    private void insert(int array[], int currentIndex) {
        // value of the element to be inserted
        int value = array[currentIndex];
        // iterate in the loop for all elements below the currentIndex
        int reverseIndex = currentIndex;

        for (int i = currentIndex - 1; i >= 0; i--) {
            // If the array element is  greater than the value
            // move the array element to the next higher index
            if (array[i] >= value) {
                array[i + 1] = array[i];
                reverseIndex = i;
            } else {
                break;
            }
        }
        array[reverseIndex] = value;
    }
}
