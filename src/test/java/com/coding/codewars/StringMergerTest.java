package com.coding.codewars;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringMergerTest {

    @Test
    public void normalHappyFlow() {
        assertTrue("codewars can be created from code and wars", StringMerger.isMerge("codewars", "code", "wars"));
        assertTrue("codewars can be created from cdwr and oeas", StringMerger.isMerge("codewars", "cdwr", "oeas"));
        assertFalse("Codewars are not codwars", StringMerger.isMerge("codewars", "cod", "wars"));
        assertTrue(StringMerger.isMerge(",`4:*(Y(H;qq)Clc6vH%+",
            "`(q)lc6H+", ",4:*Y(H;qCv%"));
    }
}