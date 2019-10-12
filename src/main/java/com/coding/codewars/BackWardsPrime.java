package com.coding.codewars;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class BackWardsPrime {

    public static String backwardsPrime(long start, long end) {
        return LongStream.range(start, end + 1).parallel()
            .filter(x -> !isPalidrome(x))
            .filter(BackWardsPrime::isPrime)
            .filter(x -> isPrime(backwards(x)))
            .boxed().map(String::valueOf).collect(Collectors.joining(" "));
    }

    public static String backwardsPrime2(long start, long end) {
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

    private static long backwards(long number) {
        return Long.parseLong(new StringBuffer(String.valueOf(number)).reverse().toString());
    }

    private static boolean isPalidrome(long number) {
        return number == backwards(number);
    }
}
