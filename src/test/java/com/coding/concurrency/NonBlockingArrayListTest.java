package com.coding.concurrency;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class NonBlockingArrayListTest {

    @Test
    public void shouldAddGetRemove() {
        var list = new NonBlockingArrayList<String>();

        list.add("item1");
        list.add("item2");
        list.add("item3");

        Assert.assertEquals(3, list.size());
        Assert.assertEquals("item3", list.get(2));
        list.remove(1);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("item3", list.get(1));


    }
}