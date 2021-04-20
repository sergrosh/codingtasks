package com.coding.interview;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringPalindromeTest {

    @Test
    public void shouldBePalindrome() {
        assertTrue(StringPalindromeUtil.isPalindrome("aba"));
    }

    @Test
    public void shouldNotBePalindrome() {
        assertFalse(StringPalindromeUtil.isPalindrome("abc"));
    }
}