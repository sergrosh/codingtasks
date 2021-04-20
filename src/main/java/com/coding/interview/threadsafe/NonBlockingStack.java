package com.coding.interview.threadsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class NonBlockingStack<T> {
    private final AtomicReference<Element> head = new AtomicReference<>(null);

    public static void main(String[] args) throws InterruptedException {
        NonBlockingStack<Integer> nonBlockingStack = new NonBlockingStack<>();

        Thread runnable1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                nonBlockingStack.push(i);
            }
        });

        Thread runnable2 = new Thread(() -> {
            for (int i = 101; i <= 200; i++) {
                nonBlockingStack.push(i);
            }
        });

        Thread runnable3 = new Thread(() -> {
            for (int i = 201; i <= 300; i++) {
                nonBlockingStack.push(i);
            }
        });

        Thread runnable4 = new Thread(() -> {
            for (int i = 301; i <= 400; i++) {
                nonBlockingStack.push(i);
            }
        });

        Thread runnable5 = new Thread(() -> {
            for (int i = 401; i <= 500; i++) {
                nonBlockingStack.push(i);
            }
        });

        Runnable runnablePop = () -> {
            for (int i = 1; i <= 500; i++) {
                nonBlockingStack.pop();
            }
        };
        long startTime = System.currentTimeMillis();
        runnable1.start();
        runnable2.start();
        runnable3.start();
        runnable4.start();
        runnable5.start();
        runnable1.join();
        runnable2.join();
        runnable3.join();
        runnable4.join();
        runnable5.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Duration time is " + (endTime - startTime) + " ms");
    }

    NonBlockingStack<T> push(final T value) {
        final Element current = new Element();
        current.value = value;
        Element recent;
        int i = 1;
        do {
            System.out.println("Trying to push value " + value + " - " + i + " time");
            recent = head.get();
            current.previous = recent;
        } while (!head.compareAndSet(recent, current));
        return this;
    }

    T pop() {
        Element result;
        Element previous;
        int i = 0;
        do {
            try {
                TimeUnit.MILLISECONDS.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = head.get();
            if (result == null) {
                return null;
            }
            previous = result.previous;
            i++;
        } while (!head.compareAndSet(result, previous));
        System.out.println("Trying to pop value " + result.value + " - " + i + " time");
        return result.value;
    }

    private class Element {
        private T value;
        private Element previous;
    }
}
