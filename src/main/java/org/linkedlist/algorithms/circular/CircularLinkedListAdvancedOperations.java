package org.linkedlist.algorithms.circular;

import org.linkedlist.algorithms.model.CircularNode;

public class CircularLinkedListAdvancedOperations {


    // Josephus Problem (Return the last remaining node's data)
    public static int josephus(int n, int k) {
        // Recursive solution to the Josephus problem
        if (n == 1) return 1;  // Only one person left, return their position (1-based)
        return (josephus(n - 1, k) + k - 1) % n + 1; // Recursive formula for Josephus Problem
    }


    public static CircularNode sortedInsert(CircularNode head, int data) {
        CircularNode newNode = new CircularNode(data);
        if (head == null) return newNode;

        CircularNode current = head;

        // If the data is smaller than the head, insert before the head
        if (data < head.getData()) {
            // Traverse to the last node to set the circular link correctly
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
            head = newNode;
        } else {
            // Traverse to find the correct insertion point
            while (current.getNext() != head && current.getNext().getData() < data) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        return head;
    }

}