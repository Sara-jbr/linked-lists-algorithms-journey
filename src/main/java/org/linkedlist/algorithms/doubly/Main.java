package org.linkedlist.algorithms.doubly;

import org.linkedlist.algorithms.model.DoublyNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Basic Operations
        System.out.println("=== Basic Operations ===");
        DoublyNode head = null;
        head = DoublyLinkedListBasicOperations.insertAtEnd(head, 10);
        head = DoublyLinkedListBasicOperations.insertAtEnd(head, 20);
        head = DoublyLinkedListBasicOperations.insertAtBeginning(head, 5);
        DoublyLinkedListBasicOperations.traverse(head);
        head = DoublyLinkedListBasicOperations.deleteNode(head, 20);
        DoublyLinkedListBasicOperations.traverse(head);


        // Intermediate Operations
        System.out.println("\n=== Intermediate Operations ===");
        head = DoublyLinkedListBasicOperations.insertAtEnd(head, 30);
        head = DoublyLinkedListBasicOperations.insertAtEnd(head, 40);
        head = DoublyLinkedListIntermediateOperations.reverse(head);
        DoublyLinkedListBasicOperations.traverse(head);

        System.out.println("Pairs with sum 35:");
        DoublyLinkedListIntermediateOperations.findPairsWithSum(head, 35);

        System.out.println("After Insertion Sort:");
        head = DoublyLinkedListIntermediateOperations.insertionSort(head);
        DoublyLinkedListBasicOperations.traverse(head);


        // Advanced: LRU Cache
        System.out.println("\n=== LRU Cache ===");
        DoublyLinkedListAdvancedOperations.LRUCache cache = new DoublyLinkedListAdvancedOperations.LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.displayCache();  // (3:30)(2:20)(1:10)
        cache.get(2);
        cache.displayCache();  // (2:20)(3:30)(1:10)
        cache.put(4, 40);       // Evicts key 1
        cache.displayCache();  // (4:40)(2:20)(3:30)

        // All Palindromic Partitions
        System.out.println("\n=== All Palindromic Partitions of 'aab' ===");
        List<List<String>> partitions = DoublyLinkedListAdvancedOperations.allPalindromicPartitions("aab");
        for (List<String> part : partitions) {
            System.out.println(part);
        }
    }
}
