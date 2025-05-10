package org.linkedlist.algorithms.doubly;

import java.util.*;

public class DoublyLinkedListAdvancedOperations {

    //  1. LRU Cache Implementation
    public static class LRUCache {
        private final int capacity;
        private final Map<Integer, Node> map;
        private final Node head, tail;

        private static class Node {
            int key, value;
            Node prev, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            remove(node);
            insertToFront(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node(key, value);
            insertToFront(node);
            map.put(key, node);
        }

        private void insertToFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void displayCache() {
            Node curr = head.next;
            while (curr != tail) {
                System.out.print("(" + curr.key + ":" + curr.value + ") ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

    //  2. All Possible Palindromic Partitions
    public static List<List<String>> allPalindromicPartitions(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, List<String> current, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (isPalindrome(prefix)) {
                current.add(prefix);
                backtrack(result, current, s, end);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
