package com.coding.interview.stack;

import java.util.Stack;

public class QueueWithTwoStacks<E> {
    private Stack<E> inbox = new Stack<>();
    private Stack<E> outbox = new Stack<>();

    public void enqueue(E element){
        inbox.push(element);
    }

    public E dequeue(){
        if(outbox.isEmpty()){
            while (!inbox.isEmpty()){
                outbox.push(inbox.pop());
            }
        }

        return outbox.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
