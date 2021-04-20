package com.coding.hackerrank.string;

import java.util.Arrays;

public class Anagram {

    static boolean isAnagram(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("some", "emos"));
    }
}
