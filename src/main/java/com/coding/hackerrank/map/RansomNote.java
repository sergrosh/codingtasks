package com.coding.hackerrank.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {

    static void checkMagazineJava8(String[] magazine, String[] note) {
        Map<String, Long> magazineMap = Arrays.stream(magazine)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String word : note) {
            if (magazineMap.get(word) != null && magazineMap.get(word) > 0) {
                magazineMap.computeIfPresent(word, (key, value) -> value - 1);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        int flag=0;
        for(String magazineWord : magazine)
        {
            if(freqMap.containsKey(magazineWord))
            {
                int freq = freqMap.get(magazineWord)+1;
                freqMap.put(magazineWord, freq);
            }
            else
                freqMap.put(magazineWord, 1);
        }
        for(String noteWord : note)
        {
            if(freqMap.containsKey(noteWord))
            {
                int freq = freqMap.get(noteWord)-1;
                if(freq==0)
                    freqMap.remove(noteWord);
                else
                    freqMap.put(noteWord, freq);
            }
            else
            {
                System.out.println("No");
                flag=1;
                break;
            }
        }
        if(flag==0)
            System.out.println("Yes");
    }

    public static void main(String[] args) {
        checkMagazine("two times three is not four".split(" "), "two times two is four".split(" "));
    }

}
