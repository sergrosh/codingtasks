package com.coding.leetcode.easy.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest {

    @Test
    public void shouldReverse() {
        assertEquals(321, ReverseInteger.reverse(123));
        assertEquals(-321, ReverseInteger.reverse(-123));
        assertEquals(0, ReverseInteger.reverse(-2147483648));
    }
}