package org.linkedlist.algorithms.circular;

import org.linkedlist.algorithms.model.CircularNode;

public class Main {
    public static void main(String[] args) {

        // Create initial circular linked list
        int[] data = {10, 20, 30, 40, 50};
        CircularNode head = CircularLinkedListBasicOperations.createList(data);
        printList(head, 10);  // Display up to 10 elements

        // Insert a new node at the end of the list
        head = CircularLinkedListBasicOperations.insert(head, 60);
        printList(head, 10);

        //  Delete a node with value 30
        head = CircularLinkedListBasicOperations.delete(head, 30);
        printList(head, 10);

        // Sorted insert into a circular linked list
        head = CircularLinkedListAdvancedOperations.sortedInsert(head, 25);
        printList(head, 10);

        // Split the list into two halves
        CircularNode[] split = CircularLinkedListIntermediateOperations.splitList(head);
        System.out.println("First half:");
        printList(split[0], 10);
        System.out.println("Second half:");
        printList(split[1], 10);

        // Solve the Josephus problem
        int n = 7;
        int k = 3;
        int winner = CircularLinkedListAdvancedOperations.josephus(n, k);
        System.out.println("Josephus winner for n=" + n + ", k=" + k + ": " + winner);

        // Detect loop in the circular linked list
        boolean hasLoop = CircularLinkedListIntermediateOperations.detectLoop(head);
        System.out.println("Detect loop in list: " + hasLoop);
    }

    // Helper method to print the circular list with a limit to avoid infinite loops
    public static void printList(CircularNode head, int limit) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        CircularNode temp = head;
        int count = 0;
        do {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
            count++;
        } while (temp != head && count < limit);
        System.out.println("(back to head)");
    }
}
