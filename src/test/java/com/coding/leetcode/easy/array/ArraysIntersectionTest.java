package com.coding.leetcode.easy.array;

import java.util.Arrays;

import org.junit.Test;

public class ArraysIntersectionTest {

    @Test
    public void checkArraysIntersection() {
        int[] arr1 = new int[]{4, 9, 5};
        int[] arr2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(ArraysIntersection.intersect(arr1, arr2)));
    }
}
