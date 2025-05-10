package org.linkedlist.algorithms.singly;


import org.linkedlist.algorithms.model.SinglyNode;

public class SinglyLinkedListBasicOperations {

    public static SinglyNode insertAtBeginning(SinglyNode head, int data) {
        SinglyNode newNode = new SinglyNode(data);
        newNode.setNext(head);
        return newNode;
    }

    public static SinglyNode insertAtEnd(SinglyNode head, int data) {
        SinglyNode newNode = new SinglyNode(data);
        if (head == null) return newNode;
        SinglyNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        return head;
    }

    public static SinglyNode deleteNode(SinglyNode head, int key) {
        if (head == null) return null;
        if (head.getData() == key) return head.getNext();

        SinglyNode current = head;
        while (current.getNext() != null && current.getNext().getData() != key) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }

        return head;
    }

    public static boolean searchNode(SinglyNode head, int key) {
        while (head != null) {
            if (head.getData() == key) return true;
            head = head.getNext();
        }
        return false;
    }

    public static void traverseList(SinglyNode head) {
        while (head != null) {
            System.out.print(head.getData() + " -> ");
            head = head.getNext();
        }
        System.out.println("null");
    }
}

