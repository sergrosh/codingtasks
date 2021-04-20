package com.coding.interview;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    static int getFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    static List<Integer> getFibonnaci2(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        if (n == 1 || n == 2) {
            return list;
        }
        int fibo = 1;
        int fibo1 = 1;
        int fibo2 = 1;
        for (int i = 3; i <= n; i++) {
            fibo = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibo;
            list.add(fibo);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getFibonacci(10));
        System.out.println(getFibonnaci2(10));
    }
}
