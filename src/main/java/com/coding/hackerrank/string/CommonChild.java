package com.coding.hackerrank.string;

public class CommonChild {
    // Complete the commonChild function below.
    static int findMaxCommonLength(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] commonLengths = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    commonLengths[i][j] = commonLengths[i - 1][j - 1] + 1;
                } else {
                    commonLengths[i][j] = Math.max(commonLengths[i - 1][j], commonLengths[i][j - 1]);
                }
            }
        }
        return commonLengths[length1][length2];
    }

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int length1 = s1.length();
        int length2 = s2.length();

        int[] memo = new int[length2 + 1];

        for (int i = 1; i <= length1; i++) {
            int prev = 0;
            for (int j = 1; j <= length2; j++) {
                int temp = memo[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                }
                prev = temp;
            }
        }
        return memo[length2];
    }

    public static void main(String[] args) {
        System.out.println(commonChild("HARRYBN", "SAAALLYWK"));
    }
}
