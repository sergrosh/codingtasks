package com.coding.interview;

public class FactorialExample {

    public static void main(String[] args) {
        System.out.println(getFactorial(10));
        System.out.println(getFactorial2(10));
    }

    static int getFactorial(int number) {
        if (number < 1) {
            return -1;
        }
        if (number == 1) {
            return 1;
        }
        return number * getFactorial(number - 1);
    }

    static int getFactorial2(int number) {
        if (number < 1) {
            return 0;
        }
        int factorial = 1;
        while (number > 0) {
            factorial *= number;
            number--;
        }
        return factorial;
    }

}
