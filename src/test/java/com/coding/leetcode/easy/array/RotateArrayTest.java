package com.coding.leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

public class RotateArrayTest {

    @Test
    public void rotate() {
        int[] testArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        RotateArray.rotateWithCyclicReplacement(testArray, 3);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, testArray);
    }
}