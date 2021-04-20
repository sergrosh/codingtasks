package com.coding.interview;

public class StringPalindromeUtil {

    private StringPalindromeUtil() {
    }

    static boolean isPalindrome(String candidate) {
        return candidate.equals(reverseString(candidate));
    }

    private static String reverseString(String candidate) {
        if (candidate.length() == 1) {
            return candidate;
        }
        return reverseString(candidate.substring(1)) + candidate.charAt(0);
    }


}
