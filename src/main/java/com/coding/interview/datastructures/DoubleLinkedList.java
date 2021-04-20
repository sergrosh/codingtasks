package com.coding.interview.datastructures;

public class DoubleLinkedList<E extends Comparable<E>> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.addInc(-5);
        doubleLinkedList.addInc(-200);
        doubleLinkedList.addInc(7);
        doubleLinkedList.addInc(11);
        doubleLinkedList.addInc(3);
        doubleLinkedList.addInc(5);
        doubleLinkedList.addInc(0);
        doubleLinkedList.addInc(25);
        doubleLinkedList.addInc(-1);
        doubleLinkedList.addInc(50);
        doubleLinkedList.addInc(-500);
        doubleLinkedList.addInc(500);
        doubleLinkedList.reverse();
        System.out.println(doubleLinkedList);
        System.out.println("Size is: " + doubleLinkedList.getSize());
        System.out.println("Head is: " + doubleLinkedList.getHead().getElement());
        System.out.println("Tail is: " + doubleLinkedList.getTail().getElement());
        doubleLinkedList.reverse();
        System.out.println(doubleLinkedList);
        System.out.println("Size is: " + doubleLinkedList.getSize());
        System.out.println("Head is: " + doubleLinkedList.getHead().getElement());
        System.out.println("Tail is: " + doubleLinkedList.getTail().getElement());

        DoubleLinkedList<Integer> doubleLinkedList2 = new DoubleLinkedList<>();
        doubleLinkedList2.addInc(50);
        doubleLinkedList2.addInc(500);

        System.out.println(doubleLinkedList.findMergeNode(doubleLinkedList2.getHead()));

        doubleLinkedList.addInc(500);
        doubleLinkedList.addInc(-500);
        doubleLinkedList.addInc(200);
        doubleLinkedList.addInc(3);
        doubleLinkedList.addInc(5);

        System.out.println(doubleLinkedList);

        doubleLinkedList.removeDuplicates();

        System.out.println(doubleLinkedList);

        System.out.println(doubleLinkedList.getNthToLast(3));

        Node<Integer> node1 = new Node<>(3, new Node<>(1, new Node<>(5, null, null), null), null);
        Node<Integer> node2 = new Node<>(5, new Node<>(9, new Node<>(2, null, null), null), null);
        System.out.println(node1);
        System.out.println(node2);

        System.out.println(calculateSum(node1, node2, 0));

        Node<Integer> nodeWithCycle = new Node<>(1, null, null);
        Node<Integer> secondNode = new Node<>(2, null, null);
        Node<Integer> node3 = new Node<>(3, null, null);
        Node<Integer> node4 = new Node<>(4, null, null);
        Node<Integer> node5 = new Node<>(5, null, null);
        Node<Integer> node6 = new Node<>(6, null, null);
        Node<Integer> node7 = new Node<>(7, null, null);
        Node<Integer> node8 = new Node<>(8, null, null);
        Node<Integer> node9 = new Node<>(9, null, null);
        Node<Integer> node10 = new Node<>(10, null, null);
        Node<Integer> node11 = new Node<>(11, null, null);

        nodeWithCycle.setNext(secondNode.setNext(node3.setNext(node4.setNext(node5.setNext(node6.setNext(node7.setNext(node8.setNext(node9.setNext(node10.setNext(node11.setNext(node4)))))))))));

        doubleLinkedList.findCycleNode(nodeWithCycle);


    }

    public static Node<Integer> calculateSum(Node<Integer> node1, Node<Integer> node2, int carry) {
        if (node1 == null && node2 == null) {
            return null;
        }
        Node<Integer> result = new Node<>(carry, null, null);
        int value = carry;
        if (node1 != null) {
            value += node1.element;
        }

        if (node2 != null) {
            value += node2.element;
        }

        result.element = value % 10;

        Node<Integer> next = calculateSum(node1.next == null ? null : node1.next,
                node2.next == null ? null : node2.next, value >= 10 ? 1 : 0);
        result.setNext(next);
        return result;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public Node<E> add(E element) {
        Node<E> previous;
        Node<E> current;
        if (head == null) {
            current = new Node<>(element, null, null);
            head = tail = current;
            size++;
            return head;
        }
        previous = tail;
        current = new Node<>(element, null, previous);
        previous.setNext(current);
        tail = current;
        size++;
        return head;
    }

    public Node<E> add(int position, E element) {
        Node<E> current;
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position index (" + position + ") is out of bounds (size of list is " + size + ").");
        } else if (position == size) {
            return add(element);
        } else if (position == 0) {
            current = new Node<>(element, head, null);
            head.setPrevious(current);
            head = current;
        } else {
            int counter = 1;
            Node<E> previous = head;
            while (counter != position) {
                previous = previous.getNext();
                counter++;
            }
            Node<E> next = previous.next;
            current = new Node<>(element, next, previous);
            previous.setNext(current);
            next.setPrevious(current);
        }
        return head;
    }

    public Node<E> addInc(E element) {
        Node<E> current;
        if (head == null) {
            current = new Node<>(element, null, null);
            head = tail = current;
            size++;
            return head;
        }

        Node<E> compared = head;
        int counter = 0;
        while (counter < size && element.compareTo(compared.getElement()) > 0) {
            if (compared.hasNext()) {
                compared = compared.getNext();
            }
            counter++;
        }
        if (!compared.hasPrevious()) {
            if (element.compareTo(compared.getElement()) > 0) {
                current = new Node<>(element, null, head);
                head.setNext(current);
                tail = current;
            } else {
                current = new Node<>(element, head, null);
                head.setPrevious(current);
                head = current;
            }
        } else if (compared.hasNext()) {
            current = new Node<>(element, compared, compared.getPrevious());
            compared.getPrevious().setNext(current);
            compared.setPrevious(current);
        } else {
            current = new Node<>(element, null, compared);
            compared.setNext(current);
            tail = current;
        }
        size++;
        return head;
    }


    public void reverse() {
        if (head == null || !head.hasNext()) {
            return;
        }

        Node<E> current = head, prev = null, next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            current.setPrevious(next);
            prev = current;
            current = next;
        }
        Node<E> temp = head;
        head = tail;
        tail = temp;

    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        Node<E> current = head.getNext();
        while (current != null) {
            Node<E> runner = head;
            while (runner != current) {
                if (runner.getElement().equals(current.getElement())) {
                    current.getPrevious().setNext(current.getNext());
                    if (current.getNext() != null) {
                        current.getNext().setPrevious(current.getPrevious());
                    }
                    current = current.next;
                }
                runner = runner.next;
            }
            if (current == null) {
                return;
            }
            current = current.next;
        }
    }

    E findMergeNode(Node<E> head2) {
        Node<E> temp1 = head, temp2 = head2;
        while (temp1 != null) {
            while (temp2 != null) {
                if (temp1.getElement().equals(temp2.getElement())) {
                    return temp1.getElement();
                }
                temp2 = temp2.getNext();
            }
            temp1 = temp1.getNext();
            temp2 = head2;
        }
        return null;
    }

    public E getNthToLast(int n) {
        if (head == null || n < 1) {
            return null;
        }
        Node<E> pointer1 = head;
        Node<E> pointer2 = head;

        for (int i = 0; i < n; i++) {
            if (pointer1 == null) {
                return null;
            }
            pointer1 = pointer1.next;
        }
        while (pointer1.hasNext()) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer2.getElement();
    }

    public Node<E> findCycleNode(Node<E> head) {
        Node<E> fast = head;
        Node<E> slow = head;
        while (fast.hasNext()) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (!fast.hasNext()) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> current = head;
        while (current.hasNext()) {
            builder.append(current.getElement()).append("->");
            current = current.getNext();
        }
        builder.append(current.getElement());
        return builder.toString();
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(E element, Node<E> next, Node<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> setNext(Node<E> next) {
            this.next = next;
            return this;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrevious() {
            return previous != null;
        }

        @Override
        public String toString() {
//            if (hasNext()) {
//                return element + " -> " + next;
//            } else {
            return element.toString();
            //}
        }
    }
}
