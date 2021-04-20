package com.coding.hackerrank.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;

            if (counter.containsKey(key) && a % r == 0) {
                count += counter.get(key);
            }

            if (potential.containsKey(key) && a % r == 0) {
                long c = potential.get(key);
                counter.put(a, counter.getOrDefault(a, 0L) + c);
            }

            potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
        }
        return count;


    }

    public static void main(String[] args) {
        System.out.println(countTriplets(List.of(1L, 3L, 9L, 9L, 27L, 81L), 3));
    }
}
