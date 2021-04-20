package com.coding.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindTriplets {
    static void find_all_triplets(int arr[], int n, int sum) {
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == sum) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }
    }

    static void findTriplets(int[] arr, int n, int sum) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == sum) {
                    System.out.println(x + " " + arr[l] + " " + arr[r]);
                    l++;
                    r--;
                } else if (x + arr[l] +
                        arr[r] < sum)
                    l++;

                else
                    r--;
            }
        }
    }

    static List<List<Integer>> findTriplets2(int arr[], int n, int sum) {
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to
            // "sum-arr[i]"
            HashSet<Integer> target = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int x = sum - (arr[i] + arr[j]);
                if (target.contains(x)) {
                    pairs.add(List.of(x, arr[i], arr[j]));
                } else {
                    target.add(arr[j]);
                }
            }
        }
        return pairs;
    }


    public static void main(String[] args) {
        int arr[] = {3,3,3,3};
        int n = arr.length;
        System.out.println(findTriplets2(arr, n, 9));
    }
}
