package org.linkedlist.algorithms.model;

public class CircularNode {
    private int data;
    private CircularNode next;

    public CircularNode(int data) {
        this.data = data;
        this.next = this; // Circular reference
    }

    public int getData() {
        return data;
    }

    public CircularNode getNext() {
        return next;
    }

    public void setNext(CircularNode next) {
        this.next = next;
    }
}

