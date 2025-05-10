package org.linkedlist.algorithms.singly;


import org.linkedlist.algorithms.model.SinglyNode;

public class SinglyLinkedListAdvancedOperations {

    public static SinglyNode reverseKGroup(SinglyNode head, int k) {
        SinglyNode current = head;
        int count = 0;

        while (current != null && count < k) {
            current = current.getNext();
            count++;
        }

        if (count == k) {
            current = reverseKGroup(current, k);
            while (count-- > 0) {
                SinglyNode temp = head.getNext();
                head.setNext(current);
                current = head;
                head = temp;
            }
            head = current;
        }
        return head;
    }


    public static boolean isPalindrome(SinglyNode head) {
        if (head == null || head.getNext() == null) return true;

        SinglyNode slow = head, fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        SinglyNode secondHalf = SinglyLinkedListIntermediateOperations.reverseList(slow);
        SinglyNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.getData() != secondHalf.getData()) return false;
            firstHalf = firstHalf.getNext();
            secondHalf = secondHalf.getNext();
        }
        return true;
    }

    public static SinglyNode addTwoNumbers(SinglyNode l1, SinglyNode l2) {
        SinglyNode dummy = new SinglyNode(0);
        SinglyNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.getData();
                l1 = l1.getNext();
            }

            if (l2 != null) {
                sum += l2.getData();
                l2 = l2.getNext();
            }

            current.setNext(new SinglyNode(sum % 10));
            carry = sum / 10;
            current = current.getNext();
        }

        return dummy.getNext();
    }

    public static SinglyNode getIntersectionNode(SinglyNode headA, SinglyNode headB) {
        SinglyNode a = headA;
        SinglyNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.getNext();
            b = (b == null) ? headA : b.getNext();
        }

        return a;
    }


    public static SinglyNode flattenMultilevelList(SinglyNode head) {
        if (head == null) return null;
        flattenDFS(head);
        return head;
    }

    private static SinglyNode flattenDFS(SinglyNode node) {
        SinglyNode current = node;
        SinglyNode last = null;

        while (current != null) {
            SinglyNode next = current.getNext();


            if (current.getChild() != null) {
                SinglyNode childHead = current.getChild();
                SinglyNode childTail = flattenDFS(childHead);

                current.setNext(childHead);
                current.setChild(null);


                if (childTail != null) {
                    childTail.setNext(next);
                }
                last = childTail;
            } else {
                last = current;
            }

            current = next;
        }
        return last;
    }
}
