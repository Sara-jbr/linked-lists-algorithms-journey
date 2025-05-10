package org.linkedlist.algorithms.singly;

import org.linkedlist.algorithms.model.SinglyNode;

import static org.linkedlist.algorithms.singly.SinglyLinkedListAdvancedOperations.*;
import static org.linkedlist.algorithms.singly.SinglyLinkedListBasicOperations.*;
import static org.linkedlist.algorithms.singly.SinglyLinkedListIntermediateOperations.*;

public class Main {
    public static void main(String[] args) {

        // 1. Create a simple linked list: 1 -> 2 -> 3 -> 4 -> 5
        SinglyNode head = null;
        for (int i = 5; i >= 1; i--) {
            head = insertAtBeginning(head, i);
        }
        System.out.println("1. Original list:");
        traverseList(head);

        // 2. Reverse the linked list
        SinglyNode reversed = reverseList(head);
        System.out.println("2. Reversed list:");
        traverseList(reversed);

        // 3. Find the middle node of the list
        SinglyNode middle = findMiddleNode(reversed);
        System.out.println("3. Middle node: " + middle.getData());

        // 4. Check if the list has a cycle (should return false here)
        System.out.println("4. Has cycle: " + detectCycle(reversed));

        // 5. Remove the 2nd node from the end of the list
        SinglyNode removed = removeNthFromEnd(reversed, 2);
        System.out.println("5. After removing 2nd from end:");
        traverseList(removed);

        // 6. Merge two sorted linked lists
        SinglyNode l1 = insertAtBeginning(null, 4);
        l1 = insertAtBeginning(l1, 2);
        SinglyNode l2 = insertAtBeginning(null, 5);
        l2 = insertAtBeginning(l2, 1);
        SinglyNode merged = mergeTwoSortedLists(l1, l2);
        System.out.println("6. Merged sorted lists:");
        traverseList(merged);

        // 7. Insert a node at the end
        merged = insertAtEnd(merged, 10);
        System.out.println("7. After inserting 10 at end:");
        traverseList(merged);

        // 8. Delete a node with value 4
        merged = deleteNode(merged, 4);
        System.out.println("8. After deleting 4:");
        traverseList(merged);

        // 9. Search for a node with value 5
        System.out.println("9. Search for 5: " + searchNode(merged, 5));

        // 10. Traverse the list
        System.out.println("10. Traversing list:");
        traverseList(merged);

        // 11. Reverse the list in groups of k=2
        SinglyNode kReversed = reverseKGroup(merged, 2);
        System.out.println("11. K-group reversed (k=2):");
        traverseList(kReversed);

        // 12. Check if the list is a palindrome
        SinglyNode pal = insertAtBeginning(null, 1);
        pal = insertAtBeginning(pal, 2);
        pal = insertAtBeginning(pal, 2);
        pal = insertAtBeginning(pal, 1);
        System.out.println("12. Is palindrome: " + isPalindrome(pal));

        // 13. Add two numbers represented by linked lists (e.g., 342 + 465 = 807)
        SinglyNode num1 = insertAtBeginning(null, 3);
        num1 = insertAtBeginning(num1, 4);
        num1 = insertAtBeginning(num1, 2);
        SinglyNode num2 = insertAtBeginning(null, 5);
        num2 = insertAtBeginning(num2, 6);
        num2 = insertAtBeginning(num2, 4);
        SinglyNode sum = addTwoNumbers(num1, num2);
        System.out.println("13. Sum of numbers:");
        traverseList(sum);

        // 14. Find the intersection node of two linked lists
        SinglyNode common = new SinglyNode(8);
        common.setNext(new SinglyNode(10));
        SinglyNode listA = new SinglyNode(3);
        listA.setNext(new SinglyNode(7));
        listA.getNext().setNext(common);
        SinglyNode listB = new SinglyNode(99);
        listB.setNext(common);
        SinglyNode intersection = getIntersectionNode(listA, listB);
        System.out.println("14. Intersection at: " + (intersection != null ? intersection.getData() : "No intersection"));

        // 15. Flatten a multilevel linked list
        SinglyNode multi = new SinglyNode(1);
        SinglyNode child = new SinglyNode(2);
        child.setNext(new SinglyNode(3));
        multi.setChild(child);
        SinglyNode flat = flattenMultilevelList(multi);
        System.out.println("15. Flatten multilevel list:");
        traverseList(flat);
    }


}
