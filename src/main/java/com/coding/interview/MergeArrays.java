package com.coding.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class MergeArrays {

    static int[] merge(int[] arr1, int[] arr2) {
        int[] destination = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int destinationIndex = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                destination[destinationIndex++] = arr1[index1++];
            } else {
                destination[destinationIndex++] = arr2[index2++];
            }
        }

        System.arraycopy(arr1, index1, destination, destinationIndex, arr1.length - index1);
        System.arraycopy(arr2, index2, destination, destinationIndex, arr2.length - index2);
        return destination;

    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 5, 7, 9};
        int[] arr2 = new int[]{2, 4, 8};

        System.out.println(Arrays.toString(merge(arr1, arr2)));

        Integer a = 10;
        Integer b = 10;

        Integer c = 127;
        Integer d = 127;

        System.out.println(a == b);
        System.out.println(c == d);

        Set<Number> set = new TreeSet<>();

        set.add(5);
        set.add(5L);
        set.add(5.0);

        List<Integer> list1 = new ArrayList();
        long start = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            if (list1.size() > 5) {
                list1.add(list1.size() - 3, i);
            } else {
                list1.add(0, i);
            }
        }
        long time = System.nanoTime() - start;
        System.out.println("Time arraylist: " + TimeUnit.NANOSECONDS.toMillis(time));

        List<Integer> list2 = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            if (list2.size() > 5) {
                list2.add(list2.size() - 3, i);
            } else {
                list2.add(0, i);
            }
        }
        time = System.nanoTime() - start;
        System.out.println("Time linkedlist: " + TimeUnit.NANOSECONDS.toMillis(time));


    }
}
