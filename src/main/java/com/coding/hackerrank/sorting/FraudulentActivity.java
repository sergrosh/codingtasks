package com.coding.hackerrank.sorting;

import java.util.LinkedList;

public class FraudulentActivity {

    public static int activityNotifications(int[] expenditure, int d) {
        int[] count = new int[201];
        int result = 0;
        for (int i = 0; i < d; i++) {
            count[expenditure[i]]++;
        }
        for (int i = d; i < expenditure.length; i++) {
            int median = getMedian(count, d);
            if (median <= expenditure[i]) {
                result++;
            }
            count[expenditure[i - d]]--;
            count[expenditure[i]]++;
        }
        return result;
    }

    public static int getMedian(int[] count, int d) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if ((2 * sum) == d) {
                return (2 * i + 1);
            } else if ((2 * sum) > d) {
                return (i * 2);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
    }
}
