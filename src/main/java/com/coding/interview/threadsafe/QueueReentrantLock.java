package com.coding.interview.threadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class QueueReentrantLock<T> {
    private final Object[] content;
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition isEmpty = lock.newCondition();
    private final Condition isFull = lock.newCondition();
    private volatile int size = 0;
    private int out;
    private int in;

    QueueReentrantLock(int capacity) {
        try {
            lock.lock();
            this.capacity = capacity;
            content = new Object[capacity];
            out = 0;
            in = 0;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        QueueReentrantLock queue = new QueueReentrantLock(2);

        executor.execute(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    queue.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
    }

    private int cycleInc(int index) {
        return (++index == capacity)
                ? 0
                : index;
    }

    @SuppressWarnings("unchecked")
    T get() throws InterruptedException {
        try {
            lock.lockInterruptibly();
            if (size == 0) {
                while (size < 1) {
                    System.out.println("Queue is empty. Waiting");
                    long startTime = System.currentTimeMillis();
                    isEmpty.await();
                    long endTime = System.currentTimeMillis();
                    System.out.println("Empty waiting time: " + (endTime - startTime) + "ms");
                }
            }
            final Object value = content[out];
            content[out] = null;
            if (size > 1) {
                out = cycleInc(out);
            }
            size--;
            TimeUnit.MILLISECONDS.sleep(25);
            isFull.signal();
            System.out.println("Return value " + value);
            return (T) value;
        } finally {
            lock.unlock();
        }
    }

    QueueReentrantLock<T> put(T value) throws InterruptedException {
        try {
            lock.lockInterruptibly();
            if (size == capacity) {
                while (size == capacity) {
                    System.out.println("Queue is full. Waiting");
                    long startTime = System.currentTimeMillis();
                    isFull.await();
                    long endTime = System.currentTimeMillis();
                    System.out.println("Full waiting time: " + (endTime - startTime) + "ms");
                }
            }
            if (size == 0) {
                content[in] = value;
            } else {
                in = cycleInc(in);
                content[in] = value;
                System.out.println("Put value " + value);
            }
            size++;
            TimeUnit.MILLISECONDS.sleep(25);
            isEmpty.signal();
        } finally {
            lock.unlock();
        }
        return this;
    }
}
