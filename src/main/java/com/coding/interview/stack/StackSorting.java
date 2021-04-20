package com.coding.interview.stack;

import java.util.Stack;

public class StackSorting {
    public static Stack<Integer> sortstack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<>();
        while (!input.isEmpty()) {
            int temp = input.pop();

            while (!tmpStack.isEmpty() && tmpStack.peek() > temp) {
                input.push(tmpStack.pop());
            }
            tmpStack.push(temp);
        }
        return tmpStack;
    }

    public static void main(String args[]) {
        Stack<Integer> input = new Stack<>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is the temporary stack
        Stack<Integer> tmpStack = sortstack(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty()) {
            System.out.print(tmpStack.pop() + " ");
        }
    }
}
