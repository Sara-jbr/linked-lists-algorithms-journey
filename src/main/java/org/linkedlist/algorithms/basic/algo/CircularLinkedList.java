package org.linkedlist.algorithms.basic.algo;

import org.linkedlist.algorithms.basic.model.CircularNode;

public class CircularLinkedList {

    private CircularNode head;

    public void add(int data) {
        CircularNode newNode = new CircularNode(data);
        if (head == null) {
            head = newNode;
            newNode.setNext(head);
        } else {
            CircularNode temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(head);
        }
    }

    public void remove(int data) {
        if (head == null) return;

        if (head.getData() == data && head.getNext() == head) {
            head = null;
            return;
        }

        CircularNode curr = head;
        CircularNode prev = null;

        do {
            if (curr.getData() == data) {
                if (curr == head) {
                    CircularNode last = head;
                    while (last.getNext() != head) {
                        last = last.getNext();
                    }
                    head = head.getNext();
                    last.setNext(head);
                } else {
                    prev.setNext(curr.getNext());
                }
                return;
            }
            prev = curr;
            curr = curr.getNext();
        } while (curr != head);
    }

    public void traverse() {
        if (head == null) return;
        CircularNode temp = head;
        do {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        } while (temp != head);
        System.out.println("(head)");
    }
}
