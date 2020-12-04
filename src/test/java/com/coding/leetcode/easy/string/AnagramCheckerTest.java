package com.coding.leetcode.easy.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramCheckerTest {

    @Test
    public void isAnagram() {
        assertTrue(AnagramChecker.isAnagram("java", "avja"));
        assertFalse(AnagramChecker.isAnagram2("java", "avj"));
    }
}