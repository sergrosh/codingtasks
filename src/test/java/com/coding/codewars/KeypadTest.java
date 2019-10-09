package com.coding.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeypadTest {

    @Test
    public void testPreses() {
        assertEquals(9, Keypad.presses("LOL"));
        assertEquals(13, Keypad.presses("HOW R U"));
    }
}