package com.coding.hackerrank.arrays;

public class HourGlassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] mat) {
        int max_sum = Integer.MIN_VALUE;
        int R = mat.length;
        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < R - 2; j++) {
                // Considering mat[i][j] as top
                // left cell of hour glass.
                int sum = (mat[i][j] + mat[i][j + 1] + mat[i][j + 2]) +
                        (mat[i + 1][j + 1]) +
                        (mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2]);

                // If previous sum is less then
                // current sum then update
                // new sum in max_sum
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]
                {{1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}
                };
        System.out.println(hourglassSum(arr));
    }
}
