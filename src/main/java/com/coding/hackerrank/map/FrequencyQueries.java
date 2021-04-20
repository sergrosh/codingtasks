package com.coding.hackerrank.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {

    static List<Integer> freqQuery(List<int[]> queries) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int[] quantities = new int[queries.size() + 1];
        List<Integer> result = new ArrayList<>();
        int frequency, value;

        for (int[] query : queries) {
            value = query[1];
            switch (query[0]) {
                case 1:
                    // process fq
                    frequency = frequencies.getOrDefault(value, 0);
                    frequencies.put(value, frequency + 1);
                    // process qt
                    quantities[frequency]--;
                    quantities[frequency + 1]++;
                    break;
                case 2:
                    // process fq
                    frequency = frequencies.getOrDefault(value, 0);
                    if (frequency == 0) break;
                    if (frequency == 1) frequencies.remove(value);
                    else frequencies.put(value, frequency - 1);
                    // process qt
                    quantities[frequency]--;
                    quantities[frequency - 1]++;
                    break;
                case 3:
                    if (value >= quantities.length) result.add(0);
                    else result.add(quantities[value] > 0 ? 1 : 0);
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<int[]> queries = List.of(new int[]{1,1}, new int[]{2,2}, new int[]{3,2}, new int[]{1,1}, new int[]{1,1},
                new int[]{2,1}, new int[]{3,2});
        List<Integer> result = freqQuery(queries);
        System.out.println(result);
    }

}
