package com.coding.leetcode.easy.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumberTest {

    @Test
    public void shouldReturnSingleNumber() {
        SingleNumber.singleNumber(new int[]{4,1,2,3,1,2,4});
    }
}