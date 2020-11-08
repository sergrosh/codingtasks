package com.coding.leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellStocksTest {

    @Test
    public void shouldCalculateCorrectMaxProfit() {
        int[] stockPrices = new int[] {7,1,5,3,6,4};
        int profit = SellStocks.maxProfit(stockPrices);
        Assert.assertEquals(profit, 7);
    }
}