package com.coding.interview;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueValueArr {

    static int findUniqueValue(int[] array) {
        Set<Integer> allValues = new HashSet<>(array.length);
        Set<Integer> uniqueValues = new LinkedHashSet<>(array.length);

        for (int value : array) {
            if (allValues.add(value)) {
                uniqueValues.add(value);
            } else {
                uniqueValues.remove(value);
            }
        }

        if (!uniqueValues.isEmpty()) {
            return uniqueValues.iterator().next();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 1, 2, 3, 4};
        System.out.println(findUniqueValue(array));

    }
}
