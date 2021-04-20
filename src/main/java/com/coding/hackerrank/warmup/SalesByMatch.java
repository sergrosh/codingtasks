package com.coding.hackerrank.warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SalesByMatch {

    static int sockMerchant(int n, int[] ar) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (set.contains(ar[i])) {
                count++;
                set.remove(ar[i]);
            } else {
                set.add(ar[i]);
            }
        }
        return count;
    }

    public static int countSocksWithStream(int[] arr) {
        return (int) Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().mapToLong(v -> v).max().getAsLong();

    }

    public static void main(String[] args) {
        System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));

    }
}
