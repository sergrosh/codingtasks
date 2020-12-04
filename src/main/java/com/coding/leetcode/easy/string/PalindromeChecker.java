package com.coding.leetcode.easy.string;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        String cleanString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return cleanString.equals((new StringBuffer(cleanString)).reverse().toString());
    }
}
