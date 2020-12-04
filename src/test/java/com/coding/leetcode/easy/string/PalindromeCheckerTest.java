package com.coding.leetcode.easy.string;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PalindromeCheckerTest {

    @Test
    public void shouldDetectIfPalindrome() {
        assertTrue(PalindromeChecker.isPalindrome("A man, a plan, a canal: Panama"));
    }
}