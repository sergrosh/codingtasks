package com.coding.interview;

public class RotateImage {

    static void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top
                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
    }

    public static void rotateInPlace90DegreesClockwise(int[][] matrix) {
        int n = matrix.length;
        int half = n / 2;

        for (int layer = 0; layer < half; layer++) {
            int first = layer;
            int last = n - 1 - first;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int j = last - offset;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[j][first];

                // bottom -> left
                matrix[j][first] = matrix[last][j];

                // right -> bottom
                matrix[last][j] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
    }

    static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        final int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        print2DArray(arr);
        rotateInPlace90DegreesClockwise(arr);
        print2DArray(arr);
//        rotateInPlace90DegreesClockwise(arr);
//        print2DArray(arr);
//        rotateInPlace90DegreesClockwise(arr);
//        print2DArray(arr);
//        rotateInPlace90DegreesClockwise(arr);
//        print2DArray(arr);
    }
}
