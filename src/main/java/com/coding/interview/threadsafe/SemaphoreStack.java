package com.coding.interview.threadsafe;

import java.util.concurrent.Semaphore;

class SemaphoreStack<T> {

    private final Semaphore semaphore = new Semaphore(1);
    private Node<T> head = null;

    public static void main(String[] args) throws InterruptedException {
        SemaphoreStack<Integer> nonBlockingStack = new SemaphoreStack<>();

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

    SemaphoreStack<T> push(T value) {
        semaphore.acquireUninterruptibly();
        try {
            head = new Node<>(value, head);
            System.out.println("Trying to push value " + value);
        } finally {
            semaphore.release();
        }
        return this;
    }

    T pop() {
        semaphore.acquireUninterruptibly();
        try {
            Node<T> current = head;
            if (current != null) {
                head = head.next;
                return current.value;
            }
            return null;
        } finally {
            semaphore.release();
        }
    }

    private static class Node<E> {
        private final E value;
        private final Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
