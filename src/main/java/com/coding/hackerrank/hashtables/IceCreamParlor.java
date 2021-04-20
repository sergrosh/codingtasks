package com.coding.hackerrank.hashtables;

import java.util.HashMap;
import java.util.Map;

public class IceCreamParlor {
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (complements.containsKey(cost[i])) {
                System.out.println(complements.get(cost[i]) + " " + (i + 1));
            } else {
                complements.put(money - cost[i], i + 1);
            }
        }
    }

    public static void main(String[] args) {
        whatFlavors(new int[]{1, 4, 5, 3, 2}, 4);
    }
}
