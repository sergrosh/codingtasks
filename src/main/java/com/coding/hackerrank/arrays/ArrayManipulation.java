package com.coding.hackerrank.arrays;

public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries)
    {
        if(n==0 || queries==null || queries.length==0){
            return -1;
        }
        long[] computation = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1] - 1;
            int k = queries[i][2];

            computation[a] += k;
            if (b + 1 < n ) {
                computation[b + 1] -= k;
            }
        }

        long max = 0; long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += computation[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(arrayManipulation(5, new int[][]{{1,2,100},{2,5,100},{3,4,100}}));
    }
}
