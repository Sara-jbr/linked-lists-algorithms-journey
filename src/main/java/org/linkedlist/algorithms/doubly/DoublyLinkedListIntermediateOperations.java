package org.linkedlist.algorithms.doubly;

import org.linkedlist.algorithms.model.DoublyNode;

public class DoublyLinkedListIntermediateOperations {

    public static DoublyNode reverse(DoublyNode head) {
        DoublyNode current = head;
        DoublyNode temp = null;

        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            head = current;
            current = current.getPrev();
        }

        return head;
    }

    public static void findPairsWithSum(DoublyNode head, int target) {
        DoublyNode first = head;
        DoublyNode second = head;

        // Move second to end
        while (second.getNext() != null) {
            second = second.getNext();
        }

        boolean found = false;
        while (first != null && second != null && first != second && second.getNext() != first) {
            int sum = first.getData() + second.getData();
            if (sum == target) {
                System.out.println("(" + first.getData() + ", " + second.getData() + ")");
                found = true;
                first = first.getNext();
                second = second.getPrev();
            } else if (sum < target) {
                first = first.getNext();
            } else {
                second = second.getPrev();
            }
        }

        if (!found) {
            System.out.println("No pair found with sum " + target);
        }
    }

    public static DoublyNode insertionSort(DoublyNode head) {
        if (head == null) return null;

        DoublyNode sorted = null;
        DoublyNode current = head;

        while (current != null) {
            DoublyNode next = current.getNext();
            current.setPrev(null);
            current.setNext(null);
            sorted = sortedInsert(sorted, current);
            current = next;
        }

        return sorted;
    }

    private static DoublyNode sortedInsert(DoublyNode head, DoublyNode newNode) {
        if (head == null) return newNode;

        if (newNode.getData() <= head.getData()) {
            newNode.setNext(head);
            head.setPrev(newNode);
            return newNode;
        }

        DoublyNode current = head;
        while (current.getNext() != null && current.getNext().getData() < newNode.getData()) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        if (current.getNext() != null) {
            current.getNext().setPrev(newNode);
        }
        current.setNext(newNode);
        newNode.setPrev(current);

        return head;
    }
}
