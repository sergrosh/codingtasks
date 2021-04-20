package com.coding.hackerrank.string;

public class SpecialString {
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            counter++;

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    if (2 * j - i < s.length() && s.substring(i, j).equals(s.substring(j + 1, 2 * j - i + 1))) {
                        counter++;
                        break;
                    } else {
                        break;
                    }
                } else {
                    counter++;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(substrCount(5, "asasd"));
    }
}
