package com.coding.leetcode.easy.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToIntTest {

    @Test
    public void checkConvert() {
        assertEquals(StringToInt.convert("  -123w"), -123);
    }
}