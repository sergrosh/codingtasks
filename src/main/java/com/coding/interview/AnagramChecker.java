package com.coding.interview;

public class AnagramChecker {

    static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        int[] letters = new int[256];
        int numUniqueChars = 0;
        int numCompleted = 0;

        char[] chars = s1.toCharArray();

        for (char c : chars) {
            int position =  c - 'a';
            if (letters[position] == 0) {
                numUniqueChars++;
            }
            letters[position]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int position = s2.charAt(i) - 'a';
            if (letters[position] == 0) {
                return false;
            }
            letters[position]--;
            if (letters[position] == 0) {
                numCompleted++;
                if (numCompleted == numUniqueChars) {
                    return i  == s2.length() - 1;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abba", "bbaa"));
    }
}
