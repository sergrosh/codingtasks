package com.coding.interview;

public class StringIntwUtil {

    static String reverseString(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }


    public static void main(String[] args) {
        String someStr = "Hello world";
        System.out.println(reverseString(someStr));
    }
}
