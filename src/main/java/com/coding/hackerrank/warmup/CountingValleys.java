package com.coding.hackerrank.warmup;

public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        int attitude = 0;
        int valleys = 0;

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'U') {
                if (attitude == -1) {
                    valleys++;
                }
                attitude++;

            } else if (path.charAt(i) == 'D') {
                attitude--;
            }
        }
        return valleys;
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "DDUUDDUUDDUU"));
    }
}
