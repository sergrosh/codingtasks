package com.coding.leetcode.easy.array;

import org.junit.Test;

public class ImageRotatorTest {

    private static final int[][] matrix = new int[][]
            {
                    {5, 1, 9, 11},
                    {2, 4, 8, 10},
                    {13, 3, 6, 7},
                    {15, 14, 12, 16}
            };

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void shouldRotateWithTransposeAndReverse() {
        printMatrix(matrix);
        ImageRotator.rotateWithTransposeAndReverse(matrix);
        System.out.println("---------------------------------");
        printMatrix(matrix);
    }

    @Test
    public void shouldRotate() {
        printMatrix(matrix);
        ImageRotator.rotate(matrix);
        System.out.println("---------------------------------");
        printMatrix(matrix);
    }

    @Test
    public void shouldFastRotate() {
        printMatrix(matrix);
        ImageRotator.fastRotate(matrix);
        System.out.println("---------------------------------");
        printMatrix(matrix);
    }
}