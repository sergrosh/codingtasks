package com.coding.codewars;

public class BackWardsPrime {

    public static String backwardsPrime(long start, long end) {
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            long rev = Long.parseLong(new StringBuilder(
                String.valueOf(start)).reverse().toString());
            if (start > 12 && isPrime(rev) && isPrime(start) && start != rev)
                sb.append(start).append(" ");
            start++;
        }
        return sb.toString().trim();
    }

    static boolean isPrime(long n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
