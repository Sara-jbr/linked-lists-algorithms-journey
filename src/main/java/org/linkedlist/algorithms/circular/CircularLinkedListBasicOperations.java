package org.linkedlist.algorithms.circular;

import org.linkedlist.algorithms.model.CircularNode;

public class CircularLinkedListBasicOperations {

        public static CircularNode createList(int[] data) {
            if (data.length == 0) return null;

            CircularNode head = new CircularNode(data[0]);
            CircularNode current = head;

            for (int i = 1; i < data.length; i++) {
                CircularNode newNode = new CircularNode(data[i]);
                current.setNext(newNode);
                current = newNode;
            }

            current.setNext(head);  // Circular reference
            return head;
        }

        public static CircularNode insert(CircularNode head, int data) {
            CircularNode newNode = new CircularNode(data);
            if (head == null) {
                newNode.setNext(newNode);  // Circular reference
                return newNode;
            }

            CircularNode current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }

            current.setNext(newNode);
            newNode.setNext(head);  // Circular reference
            return head;
        }

        public static CircularNode delete(CircularNode head, int data) {
            if (head == null) return null;

            CircularNode current = head;
            CircularNode prev = null;

            do {
                if (current.getData() == data) {
                    if (prev == null) {
                        // Deleting the head node
                        CircularNode temp = head;
                        while (temp.getNext() != head) {
                            temp = temp.getNext();
                        }
                        if (head.getNext() == head) {
                            return null;  // Only one node exists
                        }
                        temp.setNext(head.getNext());
                        head = head.getNext();
                    } else {
                        prev.setNext(current.getNext());
                    }
                    return head;
                }
                prev = current;
                current = current.getNext();
            } while (current != head);

            return head;
        }
}
