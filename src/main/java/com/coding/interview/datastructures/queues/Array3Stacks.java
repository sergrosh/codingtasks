package com.coding.interview.datastructures.queues;

import java.util.Arrays;

public class Array3Stacks {
    private int stackSize = 10;
    private int[] buffer = new int[stackSize * 3];
    private int[] stackPointer = new int[]{0, 0, 0};

    public static void main(String[] args) {
        Array3Stacks array3Stack = new Array3Stacks();
        array3Stack.push(0, 1);
        array3Stack.push(0, 1);
        array3Stack.push(0, 1);
        array3Stack.push(0, 1);
        array3Stack.push(0, 1);

        array3Stack.push(1, 2);
        array3Stack.push(1, 2);
        array3Stack.push(1, 2);
        array3Stack.push(1, 2);
        array3Stack.push(1, 2);

        array3Stack.push(2, 3);
        array3Stack.push(2, 3);
        array3Stack.push(2, 3);
        array3Stack.push(2, 3);
        array3Stack.push(2, 3);

        array3Stack.peek(0);
        array3Stack.pop(0);
        array3Stack.pop(0);
        array3Stack.pop(0);
        array3Stack.pop(0);
        array3Stack.push(0, 5);

        System.out.println(Arrays.toString(array3Stack.getBuffer()));

    }

    public int[] getBuffer() {
        return this.buffer;
    }

    public void push(int stackNum, int elem) {
        if (stackNum < 0 || stackNum > 2) {
            throw new IllegalArgumentException();
        }

        if (stackPointer[stackNum] >= stackSize) {
            throw new IllegalStateException("Queue full");
        }

        int index = stackNum * stackSize + stackPointer[stackNum];
        buffer[index] = elem;
        stackPointer[stackNum]++;
    }

    public int pop(int stackNum) {
        int index = stackNum * stackSize + stackPointer[stackNum];
        stackPointer[stackNum]--;
        int temp = buffer[index];
        buffer[index] = 0;
        return temp;
    }

    public int peek(int stackNum) {
        int index = stackNum * stackSize + stackPointer[stackNum];
        return buffer[index];
    }

    boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == stackNum * stackSize;
    }

}
