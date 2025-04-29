package org.linkedlist.algorithms.basic.model;

public class CircularNode {
   private int data;
    private CircularNode next;

    public CircularNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CircularNode getNext() {
        return next;
    }

    public void setNext(CircularNode next) {
        this.next = next;
    }
}

