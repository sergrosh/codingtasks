package com.coding.hackerrank.warmup;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int num = 0;
        int i = 0;

        while (i < c.length - 1) {
            if (i + 2 == c.length || c[i + 2] == 1) {
                i++;
            } else {
                i += 2;
            }
            num++;
        }
        return num;

    }

    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));
    }
}
