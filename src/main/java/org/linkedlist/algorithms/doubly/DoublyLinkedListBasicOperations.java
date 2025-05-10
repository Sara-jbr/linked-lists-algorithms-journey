package org.linkedlist.algorithms.doubly;

import org.linkedlist.algorithms.model.DoublyNode;

public class DoublyLinkedListBasicOperations {

    public static DoublyNode insertAtBeginning(DoublyNode head, int data) {
        DoublyNode newNode = new DoublyNode(data);
        newNode.setNext(head);
        if (head != null) {
            head.setPrev(newNode);
        }
        return newNode;
    }

    public static DoublyNode insertAtEnd(DoublyNode head, int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) return newNode;

        DoublyNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
        newNode.setPrev(current);
        return head;
    }

    public static DoublyNode deleteNode(DoublyNode head, int key) {
        if (head == null) return null;

        DoublyNode current = head;
        while (current != null && current.getData() != key) {
            current = current.getNext();
        }

        if (current == null) return head;

        if (current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());
        } else {
            head = current.getNext(); // حذف از اول لیست
        }

        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }

        return head;
    }

    public static void traverse(DoublyNode head) {
        DoublyNode last = null;

        System.out.print("Forward: ");
        while (head != null) {
            System.out.print(head.getData() + " <-> ");
            last = head;
            head = head.getNext();
        }
        System.out.println("null");

        System.out.print("Backward: ");
        while (last != null) {
            System.out.print(last.getData() + " <-> ");
            last = last.getPrev();
        }
        System.out.println("null");
    }
}
