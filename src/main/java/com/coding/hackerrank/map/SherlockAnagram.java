package com.coding.hackerrank.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnagram {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] c = s.substring(i, j + 1).toCharArray();
                Arrays.sort(c);
                map.putIfAbsent(Arrays.toString(c), 0);
                map.computeIfPresent(Arrays.toString(c), (k, v) -> v + 1);
            }
        }
        int anangramPairs = 0;

        for(Integer count : map.values()){
            anangramPairs += (count * (count -1)) /2;
        }
        return anangramPairs;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
    }
}
