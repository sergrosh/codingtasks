package com.coding.hackerrank.warmup;

public class RepeatedStrings {

    static long repeatedString(String s, long n) {
        long as = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                as++;
            }
        }
        long counter;
        long maxSeq = n / s.length();
        counter = maxSeq * as;
        int remaining = (int) (n - maxSeq * s.length());
        for (int i = 0; i < remaining; i++) {
            if (s.charAt(i) == 'a') {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 3));
        System.out.println(repeatedString("abacwat", 20));
    }
}
