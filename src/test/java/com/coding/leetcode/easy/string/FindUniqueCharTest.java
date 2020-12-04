package com.coding.leetcode.easy.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindUniqueCharTest {

    @Test
    public void shouldReturnPosition(){
        assertEquals(0, FindUniqueChar.firstUniqChar("leetcode"));
        assertEquals(2, FindUniqueChar.firstUniqChar("loveleetcode"));
    }
}