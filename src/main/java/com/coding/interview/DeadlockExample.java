package com.coding.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadlockExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Object a = new Object();
        Object b = new Object();
        executorService.execute(() -> {
            synchronized (a) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    synchronized (b) {
                        TimeUnit.SECONDS.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(() -> {
            synchronized (b) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    synchronized (a) {
                        TimeUnit.SECONDS.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
