package com.coding.interview;

import java.util.Arrays;

public class RemoveDuplicates {
    static int removeDuplicateElements(int arr[], int n) {
        Arrays.sort(arr);
        if (n == 0 || n == 1) {
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n - 1];
        // Changing original array
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        return j;
    }

    static int[] removeWithJava8(int arr[]) {
        return Arrays.stream(arr).distinct().toArray();
    }

    static void removeWithoutBuffer(int arr[]) {
        if (arr.length < 2) {
            return;
        }
        int length = arr.length;

        int tail = 1;
        for (int i = 1; i < length; i++) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }
            if (j == tail) {
                arr[tail] = arr[i];
                ++tail;
            }
        }
        arr[tail] = 0;

    }

    static String removeDuplicates(char[] str) {
        if (str == null) return "";
        int len = str.length;
        if (len < 2) return Arrays.toString(str);

        int tail = 1;

        for (int i = 1; i < len; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (str[i] == str[j]) break;
            }
            if (j == tail) {
                str[tail] = str[i];
                tail++;
            }
        }
        return String.valueOf(Arrays.copyOfRange(str, 0, tail));
    }

    public static void main(String[] args) {
        String a = "aababbcaacvaaawwerr";

        System.out.println(removeDuplicates(a.toCharArray()));
    }
}

