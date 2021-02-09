package com.coding.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;

public class QueueReentrantLockTest {

    @Test
    public void shouldPutAndGet() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        QueueReentrantLock<String> queue = new QueueReentrantLock<>(2);
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