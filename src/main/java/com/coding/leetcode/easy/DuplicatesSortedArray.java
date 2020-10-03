package com.coding.leetcode.easy;

public class DuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int lastIndexWODuplicates = 1;
        for (int originalIndex = 0; originalIndex < nums.length - 1; originalIndex++) {
            if (nums[originalIndex] != nums[originalIndex + 1]) {
                nums[lastIndexWODuplicates] = nums[originalIndex + 1];
                lastIndexWODuplicates++;
            }
        }
        return lastIndexWODuplicates;
    }
}
