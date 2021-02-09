package com.coding.concurrency;

public class QueueSynchronized<T> {
    private final Object[] content;
    private final int capacity;
    private final Object isEmpty = new Object();
    private final Object isFull = new Object();
    private volatile int size = 0;
    private int out;
    private int in;

    QueueSynchronized(final int capacity) {
        this.capacity = capacity;
        content = new Object[this.capacity];
        out = 0;
        in = 0;
        size = 0;
    }

    private int cycleInc(int index) {
        return (++index == capacity)
                ? 0
                : index;
    }

    @SuppressWarnings("unchecked")
    T get() throws InterruptedException {
        if (size == 0) {
            synchronized (isEmpty) {
                while (size < 1) {
                    isEmpty.wait();
                }
            }
        }
        try {
            synchronized (this) {
                final Object value = content[out];
                content[out] = null;
                if (size > 1) {
                    out = cycleInc(out);
                }
                size--;
                return (T) value;
            }
        } finally {
            synchronized (isFull) {
                isFull.notify();
            }
        }
    }

    QueueSynchronized<T> put(T value) throws InterruptedException {
        if (size == capacity) {
            synchronized (isFull) {
                while (size == capacity) {
                    isFull.wait();
                }
            }
        }
        synchronized (this) {
            if (size == 0) {
                content[in] = value;
            } else {
                in = cycleInc(in);
                content[in] = value;
            }
            size++;
        }
        synchronized (isEmpty) {
            isEmpty.notify();
        }
        return this;
    }
}
