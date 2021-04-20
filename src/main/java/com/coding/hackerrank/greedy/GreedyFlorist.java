package com.coding.hackerrank.greedy;

import java.util.Arrays;

public class GreedyFlorist {

    static int getMinimumCost(int k, int[] c) {
        int[] friends = new int[k];
        for (int i = 0; i < k; i++) friends[i] = c.length / k;
        for (int i = 0; i < c.length % k; i++) friends[i] += 1;

        Arrays.sort(c);
        int sum = 0, idx = 0;
        while (idx < c.length) {
            for (int j = 0; j < k; j++) {
                if (friends[j] > 0) sum += (--friends[j] + 1) * c[idx++];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumCost(2, new int[]{9, 3, 5, 7, 1}));
    }
}
