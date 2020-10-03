package com.coding.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class DuplicatesSortedArrayTest {

    @Test
    public void shouldRemoveDuplicates() {
        int[] testArray = new int[]{0, 0, 1, 2, 2, 3, 3, 4, 4, 4, 7, 8, 8};
        int testArrayLength = DuplicatesSortedArray.removeDuplicates(testArray);
        Assert.assertEquals(7, testArrayLength);
    }
}