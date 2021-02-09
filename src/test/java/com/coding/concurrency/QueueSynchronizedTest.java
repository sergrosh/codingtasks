package com.coding.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;

public class QueueSynchronizedTest {

    @Test
    public void shouldPutAndGet() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        QueueSynchronized<String> queue = new QueueSynchronized<>(2);
        executorService.execute(() -> {
            try {
                queue.put("element1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                queue.put("element2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                queue.put("element3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Assert.assertEquals("element1", queue.get());
        Assert.assertEquals("element2", queue.get());
        Assert.assertEquals("element3", queue.get());
    }
}