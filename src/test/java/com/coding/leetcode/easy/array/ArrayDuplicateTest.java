package com.coding.leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayDuplicateTest {

    @Test
    public void shouldDetectIfContainsDuplicate() {
        Assert.assertFalse(ArrayDuplicate.containsDuplicate(new int[]{3,1}));
    }
}