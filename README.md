# Linked Lists Algorithms Journey

###  Linked Lists (Singly, Doubly, Circular)

A **linked list** is a linear data structure made of elements called **nodes**. Unlike arrays, elements are not stored in contiguous memory. Each node contains:
- **Data** — the value stored.
- **Pointer(s)** — address(es) of next or previous node(s).

---

##  Singly Linked List

Each node contains:
- `Data`
- `Next` → points to the next node

### Structure

[Data | Next] → [Data | Next] → [Data | Next] → NULL

###  Advantages
- Dynamic size
- Efficient insertion/deletion at the **beginning**
- Uses less memory than doubly linked lists

###  Disadvantages
- Traversal only in **one direction**
- Deletion from the **end** is slow (needs full traversal)
- Cannot go backward

### Real-world Use Cases:
- **Stacks**: Used in depth-first search (DFS) algorithms where elements are processed in a last-in-first-out (LIFO) manner.
- **Queues**: Used in breadth-first search (BFS) or task scheduling where elements are processed in a first-in-first-out (FIFO) manner.
- **Web Browsers**: Maintaining history or back and forward buttons in browsers, where the user navigates one page at a time.

---

##  Doubly Linked List

Each node contains:
- `Prev` → points to the previous node
- `Data`
- `Next` → points to the next node

### Structure
NULL ← [Prev | Data | Next] ↔ [Prev | Data | Next] ↔ [Prev | Data | Next] → NULL

###  Advantages
- Traversal in **both directions**
- Efficient deletion from both **front and back**
- Better performance for certain algorithms (like LRU)

###  Disadvantages
- More memory (extra pointer)
- More complex node operations

### Real-world Use Cases:
- **Undo/Redo functionality**: The doubly linked list can track changes and allow moving backward and forward through the actions.
- **Browser History**: A doubly linked list can maintain the navigation history where users can go forward and backward through pages.
- **Music Players**: For managing playlists, where users can skip to the previous or next song.
- **Memory Management**: Doubly linked lists are often used in managing free and used blocks of memory in OS-level memory management (e.g., in operating systems).

---

## Circular Linked List

A **circular linked list** loops back to the start.

### Real-world Use Cases:
- **Round-robin Scheduling**: Used in CPU scheduling where each process gets a fixed time slice in a circular manner.
- **Circular Buffers**: Used in scenarios where data is continuously being produced and consumed, like in streaming or data buffering applications.
- **Music or Video Playlists**: A playlist where after the last song/video, it loops back to the first one.
- **Network Routing**: In some network protocols (like Token Ring), nodes are arranged in a circular manner to pass data.


###  Singly Circular
- Last node's `next` points to the **first node** (head)
-
[Data | Next] → [Data | Next] → [Data | Next] → (Back to first node)

###  Doubly Circular
- Last node's `next` → first node, and
- First node's `prev` → last node
-
[Prev | Data | Next] ↔ [Prev | Data | Next] ↔ [Prev | Data | Next] ↔ (Back to first node)

###  Advantages
- Can start traversal from any node
- Useful for circular queues, buffering, round-robin

###  Disadvantages
- Risk of infinite loops
- Slightly harder to implement and debug

---

##  Comparison Table

| Feature               | Singly         | Doubly         | Circular (S/D)     |
|------------------------|----------------|----------------|--------------------|
| Traversal Direction    | One-way        | Two-way        | Depends (S or D)   |
| Backward Traversal     | ❌             | ✅             | ✅ (Doubly)        |
| Uses extra memory?     | ❌             | ✅ (prev ptr)   | ✅ (loop pointer)  |
| Easy delete from end   | ❌             | ✅             | ✅                 |
| Easy delete from start | ✅             | ✅             | ✅                 |
| Infinite loop risk     | ❌             | ❌             | ✅                 |
| Use cases              | Stack, Queue   | LRU, Undo/Redo | Round-robin, buffer|

---

##  How it works in memory

Nodes can be stored **anywhere in memory**. Each node **remembers the location of the next one** through its pointer:

Example:

- Node 1 stored at address `1032`
- Node 2 stored at address `8890`
- Node 3 stored at address `4004`

Node 1's pointer holds `8890`, Node 2 holds `4004`, and so on — forming the chain.

---

##  Summary

- **Singly Linked List**: Simple, efficient for front insert/delete, forward-only.
- **Doubly Linked List**: Bi-directional, more flexible, uses more memory.
- **Circular Linked List**: Endless loop, great for buffers or round scheduling.

---

