package com.coding.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i : nums) {
            if (numsMap.containsKey(i)) {
                numsMap.put(i, numsMap.get(i) + 1);
            } else {
                numsMap.put(i, 1);
            }
        }
        int value1 = 0;
        int value2 = 0;
        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
            int secondValue = target - entry.getKey();
            if (entry.getKey() == secondValue) {
                if (entry.getValue() > 1) {
                    value1 = value2 = entry.getKey();
                    break;
                }
            } else {
                if (numsMap.containsKey(secondValue)) {
                    value1 = entry.getKey();
                    value2 = secondValue;
                    break;
                }
            }
        }

        int[] arrInd = new int[2];
        for (int j = 0; j < nums.length; j++) {
            if (value1 == nums[j]) {
                arrInd[0] = j;
                break;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (value2 == nums[k] && arrInd[0] != k) {
                arrInd[1] = k;
                break;
            }
        }

        return arrInd;
    }
}
