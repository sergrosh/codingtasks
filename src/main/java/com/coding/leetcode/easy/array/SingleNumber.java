package com.coding.leetcode.easy.array;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
