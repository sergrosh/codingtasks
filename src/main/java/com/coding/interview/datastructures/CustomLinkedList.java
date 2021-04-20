package com.coding.interview.datastructures;

public class CustomLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public static void main(String[] args) {
        Number[] numbers = new Number[3];
        numbers[0] = new Integer(10);
        numbers[1] = new Double(3.14);
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
    }

    public void add(E element) {
        if (head == null) {
            head = tail = new Node<>(element, null, null);
        } else {
            Node<E> previous = tail;
            tail = new Node<>(element, null, previous);
            previous.setNextNode(tail);
        }
        size++;
    }

    public void add(int index, E element) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index == size) {
            this.add(element);
        } else {

        }
        size++;
    }

//    private Node<E> getNode(int index) {
//        Node<E> startNode;
//        if (index < size / 2){
//
//        }else {
//
//        }
//    }


    public void print() {
        if (head == null) {
            System.out.println("No elements in your list");
        } else {
            Node<E> node = head;
            while (node != null) {
                System.out.print(node.getElement());
                if (node.hasNext()) {
                    System.out.print("->");
                }
                node = node.getNextNode();
            }
        }
    }

    public E getHead() {
        return head.getElement();
    }

    public E getTail() {
        return tail.getElement();
    }

    public static class Node<E> {

        E element;
        private Node<E> nextNode;
        private Node<E> previousNode;

        public Node(E element, Node<E> nextNode, Node<E> previousNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node previousNode) {
            this.previousNode = previousNode;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public boolean hasPrevious() {
            return previousNode != null;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }
}
