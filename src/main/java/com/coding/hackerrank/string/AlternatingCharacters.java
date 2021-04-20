package com.coding.hackerrank.string;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        char[] chars = s.toCharArray();
        int deletions = 0;
        char temp = s.charAt(0);
        for (int i = 1; i < chars.length; i++) {
            if (temp != chars[i]) {
                temp = chars[i];
            } else {
                deletions++;
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAAA"));
        System.out.println(alternatingCharacters("BBBBB"));
        System.out.println(alternatingCharacters("ABABABABABA"));
        System.out.println(alternatingCharacters("ABABABABBA"));
    }
}
