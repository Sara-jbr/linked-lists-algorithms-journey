package org.linkedlist.algorithms.singly;


import org.linkedlist.algorithms.model.SinglyNode;

public class SinglyLinkedListIntermediateOperations {

    public static SinglyNode reverseList(SinglyNode head) {
        SinglyNode prev = null;
        SinglyNode current = head;
        while (current != null) {
            SinglyNode next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    public static SinglyNode findMiddleNode(SinglyNode head) {
        if (head == null) return null;
        SinglyNode slow = head;
        SinglyNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static boolean detectCycle(SinglyNode head) {
        SinglyNode slow = head;
        SinglyNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) return true;
        }
        return false;
    }

    public static SinglyNode removeNthFromEnd(SinglyNode head, int n) {
        SinglyNode dummy = new SinglyNode(0);
        dummy.setNext(head);
        SinglyNode first = dummy;
        SinglyNode second = dummy;

        for (int i = 0; i <= n; i++) {
            if (first != null) {
                first = first.getNext();
            } else {
                return head; // n is greater than list size
            }
        }

        while (first != null) {
            first = first.getNext();
            second = second.getNext();
        }

        second.setNext(second.getNext().getNext());
        return dummy.getNext();
    }

    public static SinglyNode mergeTwoSortedLists(SinglyNode l1, SinglyNode l2) {
        SinglyNode dummy = new SinglyNode(0);
        SinglyNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.getData() < l2.getData()) {
                current.setNext(l1);
                l1 = l1.getNext();
            } else {
                current.setNext(l2);
                l2 = l2.getNext();
            }
            current = current.getNext();
        }

        if (l1 != null) current.setNext(l1);
        if (l2 != null) current.setNext(l2);

        return dummy.getNext();
    }
}
