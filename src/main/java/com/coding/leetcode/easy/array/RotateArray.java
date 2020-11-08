package com.coding.leetcode.easy.array;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int previous = nums[0];
            for (int j = 0; j < nums.length; j++) {
                if (j == 0) {
                    nums[j] = nums[nums.length - 1];
                } else {
                    int current = nums[j];
                    nums[j] = previous;
                    previous = current;
                }
            }
        }
    }

    public static void rotateWithExtraArray(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void rotateWithCyclicReplacement(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
