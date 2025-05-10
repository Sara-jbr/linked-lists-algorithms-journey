package org.linkedlist.algorithms.circular;

import org.linkedlist.algorithms.model.CircularNode;

public class CircularLinkedListIntermediateOperations {


    public static CircularNode[] splitList(CircularNode head) {
        if (head == null || head.getNext() == head) {
            return new CircularNode[]{head, null};
        }

        CircularNode slow = head, fast = head;


        while (fast.getNext() != head && fast.getNext().getNext() != head) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }


        CircularNode head1 = head;
        CircularNode head2 = slow.getNext();

        // Break the circular link and make two circular lists
        slow.setNext(head1);
        CircularNode temp = head2;
        while (temp.getNext() != head) {
            temp = temp.getNext();
        }
        temp.setNext(head2);

        return new CircularNode[]{head1, head2};
    }

     public static boolean detectLoop(CircularNode head) {
        if (head == null) return false;

        CircularNode slow = head;
        CircularNode fast = head;

         while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true; // There is a loop
            }
        }
        return false; // No loop detected
    }


}
