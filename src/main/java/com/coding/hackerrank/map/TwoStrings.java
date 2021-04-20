package com.coding.hackerrank.map;

import java.util.Arrays;

public class TwoStrings {

    static int MAX_CHAR = 26;

    // function to return true if strings have
    // common substring and no if strings have
    // no common substring
    static void twoStrings(String s1, String s2) {
        // vector for storing character occurrences
        boolean v[] = new boolean[MAX_CHAR];
        Arrays.fill(v, false);

        // increment vector index for every
        // character of str1
        for (int i = 0; i < s1.length(); i++) {
            v[s1.charAt(i) - 'a'] = true;
        }

        // checking common substring of str2 in str1
        for (int i = 0; i < s2.length(); i++) {
            if (v[s2.charAt(i) - 'a']) {
                System.out.println("Yes");
                return;
            }
        }


        System.out.println("No");
    }


    public static void main(String[] args) {
        twoStrings("hello", "world");
    }
}
