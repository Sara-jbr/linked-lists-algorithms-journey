package org.linkedlist.algorithms.basic.algo;

import org.linkedlist.algorithms.basic.model.DoublyNode;

public class DoublyLinkedList {
    private DoublyNode head;


    public void addFirst(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
    }


    public void addLast(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DoublyNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
        newNode.setPrev(temp);
    }


    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
        }
    }


    public void removeLast() {
        if (head == null) return;
        if (head.getNext() == null) {
            head = null;
            return;
        }
        DoublyNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.getPrev().setNext(null);
    }


    public void displayFromStart() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " <-> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }


    public void displayFromEnd() {
        DoublyNode temp = head;
        while (temp != null && temp.getNext() != null) {
            temp = temp.getNext();
        }
        while (temp != null) {
            System.out.print(temp.getData() + " <-> ");
            temp = temp.getPrev();
        }
        System.out.println("null");
    }
}

