package com.coding.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MoveZerosTest {

    @Test
    public void checkMoveZeros(){
        int[] arr = new int[] {0, 1, 0, 2, 0, 3, 0, 4, 0};
        MoveZeros.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

}
