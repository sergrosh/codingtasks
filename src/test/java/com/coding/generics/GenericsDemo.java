package com.coding.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList = strings; // (1) Ok
        arrayList.add(1); // (2) unchecked call
        System.out.println(arrayList);
    }


}
