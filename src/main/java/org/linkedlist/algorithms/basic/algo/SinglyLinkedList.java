package org.linkedlist.algorithms.basic.algo;

import org.linkedlist.algorithms.basic.model.Node;

public class SinglyLinkedList {

    public Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }

    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }

    public void removeLast() {
        if (head == null) return;
        if (head.getNext() == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }


    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData() == value) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }


    public void insertAt(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.getNext();
        }
        if (temp == null) return;
        Node newNode = new Node(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }

    public void deleteAt(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.getNext();
        }
        if (temp == null || temp.getNext() == null) return;
        temp.setNext(temp.getNext().getNext());
    }


    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }


    public int length() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
    }


    public int findMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow != null ? slow.getData() : -1;
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
