package com.coding.leetcode.easy.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NeedleFinderTest {

    @Test
    public void checkFinder() {
        assertEquals(-1, NeedleFinder.find("hehelloo", "ll"));
    }

}