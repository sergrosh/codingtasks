package com.coding.interview;

public class IntegerPalindrome {
    static boolean isPalindrome(int candidate) {
        int palindrome = candidate;
        int reversed = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reversed = reversed * 10 + remainder;
            palindrome = palindrome / 10;
        }
        return candidate == reversed;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }
}
