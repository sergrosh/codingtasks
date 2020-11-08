package com.coding.other;

import java.util.Stack;

public class TwoStacksDequeue<E> {
    private Stack<E> inbox = new Stack<>();
    private Stack<E> outbox = new Stack<>();

    public void queue(E item) {
        inbox.push(item);
    }

    public E offerFirst() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }

    public E offerLast() {
        if (inbox.isEmpty()) {
            while (!outbox.isEmpty()) {
                inbox.push(outbox.pop());
            }
        }
        return inbox.pop();
    }
}
