package com.coding.concurrency;

import org.junit.Assert;
import org.junit.Test;

public class NonBlockingStackWithSemaphoreTest {

    @Test
    public void shouldPushAndPop() {
        NonBlockingStackWithSemaphore<String> nonBlockingStack = new NonBlockingStackWithSemaphore<>();
        nonBlockingStack.push("element1");
        nonBlockingStack.push("element2");
        nonBlockingStack.push("element3");
        Assert.assertEquals("element3", nonBlockingStack.pop());
        Assert.assertEquals("element2", nonBlockingStack.pop());
        Assert.assertEquals("element1", nonBlockingStack.pop());
    }
}