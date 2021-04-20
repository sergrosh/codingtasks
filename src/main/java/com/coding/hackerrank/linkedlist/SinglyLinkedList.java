package com.coding.hackerrank.linkedlist;

import java.io.IOException;

public class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public static void main(String[] args) throws IOException {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertNode(1);
        singlyLinkedList.insertNode(2);
        singlyLinkedList.insertNode(3);
        singlyLinkedList.insertNodeAtPosition(singlyLinkedList.head, 5, 1);
        singlyLinkedList.printSinglyLinkedList(singlyLinkedList.head, "->");
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }

    public void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if (position == 0) {
            node.next = head;
            head = node;
        } else {
            SinglyLinkedListNode cur = head;
            int count = 1;
            while (count < position) {
                cur = cur.next;
                count++;
            }
            SinglyLinkedListNode temp = cur.next;
            cur.next = node;
            node.next = temp;
        }
        return head;
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
}
