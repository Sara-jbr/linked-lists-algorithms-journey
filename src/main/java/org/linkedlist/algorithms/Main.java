package org.linkedlist.algorithms;

import org.linkedlist.algorithms.basic.algo.SinglyLinkedList;
import org.linkedlist.algorithms.basic.algo.DoublyLinkedList;
import org.linkedlist.algorithms.basic.algo.CircularLinkedList;

public class Main {
    public static void main(String[] args) {

        // 🎯 1. Singly Linked List - Customer Queue at a Cafe
        System.out.println("=== Customer Queue at Cafe ===");
        SinglyLinkedList customerQueue = new SinglyLinkedList();

        customerQueue.addLast(101); // Customer 101 enters the queue
        customerQueue.addLast(102); // Customer 102 enters the queue
        customerQueue.addLast(103); // Customer 103 enters the queue
        customerQueue.insertAt(1, 105); // A VIP customer enters the queue at position 1 [101, 105, 102, 103]
        customerQueue.display();

        customerQueue.deleteAt(2); // Customer 102 is served [101, 105, 103]
        customerQueue.display();

        customerQueue.removeFirst(); // Customer 101 leaves after being served [105, 103]
        customerQueue.removeLast();  // Customer 103 leaves after being served [105]
        customerQueue.display();

        System.out.println("🔍 Search for customer 105: " + customerQueue.search(105));
        System.out.println("🔍 Search for customer 100: " + customerQueue.search(100));

        customerQueue.addLast(106);
        customerQueue.addLast(107);
        customerQueue.display();
        System.out.println("📏 Total customers in queue: " + customerQueue.length());
        System.out.println("🎯 Middle customer: " + customerQueue.findMiddle());

        System.out.println("🔄 Reversing the queue...");
        customerQueue.reverse();
        customerQueue.display();

        System.out.println("🌀 Is there a cycle in the queue? " + customerQueue.hasCycle());



        // 🎧 2. Doubly Linked List - Movie Playlist
        System.out.println("\n=== Movie Playlist ===");
        DoublyLinkedList moviePlaylist = new DoublyLinkedList();
        moviePlaylist.addLast(201); // Movie A
        moviePlaylist.addLast(202); // Movie B
        moviePlaylist.addLast(203); // Movie C
        moviePlaylist.displayFromStart(); // Display from the start

        // Reverse play the movies
        System.out.println("⏮ Playing movies in reverse:");
        moviePlaylist.displayFromEnd();

        // Remove the last movie from the playlist
        moviePlaylist.removeLast();
        System.out.println("🎬 After removing last movie:");
        moviePlaylist.displayFromStart();



        // 🔁 3. Circular Linked List - Round-robin Tournament System
        System.out.println("\n=== Round-robin Tournament ===");
        CircularLinkedList tournamentQueue = new CircularLinkedList();
        tournamentQueue.add(301); // Player 1
        tournamentQueue.add(302); // Player 2
        tournamentQueue.add(303); // Player 3
        tournamentQueue.add(304); // Player 4
        tournamentQueue.traverse(); // Display the order of players

        // Player 2 is removed after losing the match
        tournamentQueue.remove(302);
        System.out.println("🏆 After removing Player 2:");
        tournamentQueue.traverse();

        // Player 1 leaves after the game
        tournamentQueue.remove(301);
        System.out.println("🏅 After removing Player 1:");
        tournamentQueue.traverse();

        // Player 4 leaves after finishing the round
        tournamentQueue.remove(304);
        System.out.println("🥇 After removing Player 4:");
        tournamentQueue.traverse();
    }
}
