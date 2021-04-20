package com.coding.interview;

import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintDuplicatedChars {

    static void printDuplicatedChars(String candidate) {
        candidate.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue()>1L).forEach(System.out::println);
    }

    public static void main(String[] args) {
        printDuplicatedChars("aabbaaccdrtnngawwroopp");
    }
}
