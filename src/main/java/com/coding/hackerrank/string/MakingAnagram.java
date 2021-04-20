package com.coding.hackerrank.string;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MakingAnagram {

    static int makeAnagram(String s1, String s2) {
        Map<Character, Long> s1Map = s1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        Map<Character, Long> s2Map = s2.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));

        int deletions = 0;
        for (Map.Entry<Character, Long> entry : s1Map.entrySet()) {

            if (s2Map.containsKey(entry.getKey())) {
                deletions += Math.abs(entry.getValue() - s2Map.get(entry.getKey()));
                s2Map.remove(entry.getKey());
            } else {
                deletions += entry.getValue();
            }
        }
        deletions += s2Map.values().stream().mapToLong(Long::longValue).sum();
        return deletions;
    }

    public static int numberNeeded(String first, String second) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int length = 0;
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            if (hmap.containsKey(c)) {
                hmap.put(c, hmap.get(c) + 1);
            } else {
                hmap.put(c, 1);
            }
        }

        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            if (hmap.containsKey(c) && hmap.get(c) != 0) {
                hmap.put(c, hmap.get(c) - 1);
                length += 2;
            }
        }
        return (first.length() + second.length() - length);
    }

    public static void main(String[] args) {
        System.out.println(numberNeeded("abc", "cba"));
        System.out.println(numberNeeded("cdf", "cde"));
    }
}
