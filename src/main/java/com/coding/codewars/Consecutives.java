package com.coding.codewars;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Consecutives {

    public static List<Integer> sumConsecutives1(List<Integer> s) {
        int previous = Integer.MAX_VALUE;
        LinkedList<Integer> l = new LinkedList<>();
        for (Integer v : s) {
            l.add(v == previous ? l.pollLast() + v : v);
            previous = v;
        }
        return l;
    }

    public static List<Integer> sumConsecutives(List<Integer> s) {
        List<Integer> accumulator = new ArrayList<>();
        for (int i = 0, sum = 0; i < s.size(); i++) {
            sum += s.get(i);
            if (i == s.size() - 1 || s.get(i) != s.get(i + 1)) {
                accumulator.add(sum);
                sum = 0;
            }
        }
        return accumulator;
    }
}
