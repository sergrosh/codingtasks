package com.coding.leetcode.easy.string;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void shouldReverseString() {
        char[] testArray = {'h', 'e', 'l', 'l', 'o'};
        ReverseString.reverseString(testArray);
        Assert.assertArrayEquals(testArray, new char[]{'o', 'l', 'l', 'e', 'h'});
    }
}