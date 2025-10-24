# 🚀 Data Structures & Algorithms Journey

[![Language](https://img.shields.io/badge/Language-Java-orange.svg)](#)

---

## 👋 Welcome!

This repository documents my work and learning progression through **Data Structures and Algorithms** (DSA) from various online resources and courses.

It serves as a personal archive of the many projects, labs, exercises, and implementations of core DSA concepts.

---

## 💡 About the Course

The projects in this repository focus on implementing and utilizing the following core concepts:

* **Linear Structures:** Arrays, **Linked Lists**, **Stacks**, **Queues**, Priority Queues
* **Non-Linear Structures:** Trees, Binary Search Trees, Self-Balancing Trees, Heaps, Maps, Tries, and Hash Tables
* **Algorithmic Analysis:** Understanding **Big O notation** ($O(n)$) and analyzing the time and space efficiency of algorithms.
* **Core Concepts:** **Recursion**, generics, and object-oriented design principles.
* **Sorting & Searching:** Implementing and analyzing various sorting and searching algorithms.

---

## 🛠️ What's Inside This Repository?

This repository contains most of the code I've written in my journey through learning DSA.

> **Note:** This repository is a historical record of my learning process. The code reflects my understanding of the concepts at the time it was written.

### Key Projects

Here are some of the major projects you'll find inside:

### 1. 🎨 Fractal Drawer (Project 1)

* **Description:** An application that uses **recursion** to generate and draw intricate **fractal patterns** composed of circles, triangles, and rectangles. The program constructs the fractal pattern by repeatedly drawing smaller shapes on the corners/sides of the existing ones.
* **Key Features:**
    * [cite_start]Implemented three shape classes: `Circle.java`, `Triangle.java`, and `Rectangle.java`[cite: 363, 364, 365].
    * [cite_start]Used a recursive method to generate a pattern that repeats on itself at least 7 times[cite: 539, 540].
    * [cite_start]Computed and printed the total area of all drawn shapes[cite: 543].
* [cite_start]**Key Concepts:** **Object-Oriented Programming (OOP)**, **Classes and Methods**, **Recursion**[cite: 499], **Geometric Calculations**.
* **Technologies:** Java, `java.awt.Color`.
* **Visual:** 
### 2. ♟️ Simplified Chess Game (Project 2)

* **Description:** A command-line implementation of a simplified two-player game of chess. The game logic manages piece movement, board state, and enforces movement rules for all standard pieces.
* **Key Features:**
    * [cite_start]Utilized a **2D array of `Piece` objects** (`Board.java`) to represent the chess board[cite: 643, 684].
    * [cite_start]Implemented full movement legality checks for **Rook, Knight, Bishop, Queen, and King**[cite: 646, 647, 648, 649, 650, 793, 795].
    * [cite_start]Includes helper methods for verifying movement paths (e.g., `verifyHorizontal()`, `verifyDiagonal()`)[cite: 699, 701].
    * [cite_start]Used **Unicode characters** to display pieces in the terminal[cite: 725].
    * [cite_start]Game ends when one player's King is captured[cite: 755].
* **Key Concepts:** **2D Arrays**, **Inheritance/Polymorphism** (with `Piece` class), **OOP**, **Terminal I/O**.
* **Technologies:** Java.
* **Visual:** 
---

### 3. 🔗 Custom Lists: ArrayList vs. LinkedList (Project 3)

* **Description:** From-scratch implementations of two fundamental linear data structures: **ArrayList** (backed by a dynamic array) and **LinkedList** (using a generic node system). This project emphasizes the differences in their underlying mechanisms.
* **Key Features:**
    * [cite_start]Both classes (`ArrayList.java` and `LinkedList.java`) implement the generic `List<T>` interface[cite: 912, 942, 968].
    * [cite_start]Implemented 16 core list methods, including sorting, reversing, and duplicate removal[cite: 921, 928, 930, 931].
    * [cite_start]**ArrayList** features **dynamic resizing** (doubling array length when full)[cite: 992].
    * [cite_start]**LinkedList** sorting is performed **without converting to an array**[cite: 962].
* [cite_start]**Key Concepts:** **Interfaces**, **Generics**, **ArrayLists**, **LinkedLists**, **Big O Notation** (Runtime Analysis)[cite: 1013].
* **Technologies:** Java.
* **Visual:** 
---

### 4. 💣 Minefield (Minesweeper Clone) (Project 4)

* **Description:** An implementation of the classic Minesweeper game, focusing on the powerful use of **Stack and Queue** data structures to efficiently reveal areas of the minefield.
* **Key Features:**
    * [cite_start]Uses a **Queue** (Breadth-First Search/BFS) in `revealStartingArea()` to reveal the initial board area until a mine is reached[cite: 229, 230].
    * [cite_start]Uses a **Stack** (Depth-First Search/DFS) in `revealZeroes()` to automatically reveal all adjacent empty and numbered squares when a '0' is clicked[cite: 196, 198].
    * [cite_start]Implements game logic including mine placement, flagging, and win/loss conditions[cite: 84, 87].
    * [cite_start]Enhanced terminal output using **ANSI Color Codes** for an improved user experience[cite: 252, 253, 269].
* [cite_start]**Key Concepts:** **Stacks**, **Queues**, **Breadth-First Search (BFS)** [cite: 248][cite_start], **Depth-First Search (DFS)**[cite: 225], **2D Arrays**.
* **Technologies:** Java, ANSI Color Codes.
* **Visual:** 
---

## 🌟 A Record of Learning

This course was a fantastic experience. The projects challenged me to not only *use* data structures, but to *build them from the ground up*. This repository stands as a testament to that journey—from basic array manipulations to implementing complex, efficient, and well-designed data structures.

Feel free to browse the code!

---

Would you like to review this content, or would you like me to generate a section with instructions on how to **compile and run** these Java projects?
