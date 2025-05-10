package org.linkedlist.algorithms.model;

public class SinglyNode {
    private int data;
    private SinglyNode next;
    private SinglyNode child;

    public SinglyNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyNode getNext() {
        return next;
    }

    public void setNext(SinglyNode next) {
        this.next = next;
    }

    public SinglyNode getChild() {
        return child;
    }

    public void setChild(SinglyNode child) {
        this.child = child;
    }
}
