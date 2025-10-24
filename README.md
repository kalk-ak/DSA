# 🚀 Data Structures & Algorithms Journey

[![Language](https://img.shields.io/badge/Language-Java-orange.svg)](#)

---

## 👋 Welcome!

This repository documents my work and learning progression through **Data Structures and Algorithms** (DSA) from various online resources and courses. It serves as a personal archive of the many projects, labs, exercises, and fundamental implementations of core DSA concepts.

---

## 💡 Core Concepts Explored

The projects in this repository focus on implementing and utilizing the following key areas of computer science:

* **Linear Structures:** Arrays, **Linked Lists**, **Stacks**, **Queues**, and Priority Queues.
* **Non-Linear Structures:** Trees, Binary Search Trees, Heaps, Maps, and Hash Tables.
* **Algorithmic Analysis:** Practical application of **Big O notation** ($O(n)$) to analyze the time and space efficiency of algorithms.
* **Fundamental Principles:** **Recursion**, generics, and core object-oriented design patterns.

---

## 🛠️ Key Projects Portfolio

This section highlights the four major projects in this repository, demonstrating practical implementation of the concepts listed above.

### 1. 🎨 Fractal Drawer (Project 1)

| Detail | Description |
| :--- | :--- |
| **Goal** | Implement OOP principles and recursion to draw complex geometric patterns. |
| **Description** | [cite_start]An application that uses **recursion** to generate and draw intricate **fractal patterns** composed of circles, triangles, and rectangles[cite: 824]. [cite_start]The recursive function repeatedly draws smaller shapes based on the position and size of the existing ones[cite: 966, 1006]. |
| **Key Features** | [cite_start]Implemented three foundational shape classes (`Circle.java`, `Triangle.java`, `Rectangle.java`)[cite: 828, 829, 830]. [cite_start]The fractal must repeat itself at least 7 times, using a new color in each layer[cite: 1004]. |
| **Concepts** | **Object-Oriented Programming (OOP)**, **Classes and Methods**, **Recursion**, **Geometric Calculations**. |

**Visual:** 

---

### 2. ♟️ Simplified Chess Game (Project 2)

| Detail | Description |
| :--- | :--- |
| **Goal** | Utilize **2D arrays** and **polymorphism** to model and enforce game rules. |
| **Description** | [cite_start]A command-line implementation of a simplified two-player game of chess[cite: 576]. [cite_start]The game logic manages piece movement, board state, and enforces movement rules for all standard pieces[cite: 577, 600]. |
| **Key Features** | [cite_start]The board is represented by a **2D array of `Piece` objects** (`Board.java`)[cite: 618, 619]. [cite_start]Implemented full movement legality checks for Rook, Knight, Bishop, Queen, and King[cite: 725]. [cite_start]Used **Unicode characters** to display pieces in the terminal[cite: 659, 665]. |
| **Concepts** | **2D Arrays**, **Inheritance/Polymorphism**, **Object-Oriented Design**, **Terminal I/O**. |

**Visual:** 

---

### 3. 🔗 Custom Lists: ArrayList vs. LinkedList (Project 3)

| Detail | Description |
| :--- | :--- |
| **Goal** | Implement and compare the core functionality and runtime efficiency of two primary linear data structures. |
| **Description** | [cite_start]From-scratch implementations of a **dynamic array-backed list** (`ArrayList`) and a **generic node-based list** (`LinkedList`)[cite: 94]. This project highlights the contrasting mechanisms of linear structures. |
| **Key Features** | [cite_start]Both classes implement the generic `List<T>` interface[cite: 90]. [cite_start]**ArrayList** features **dynamic resizing** (doubling array length when full)[cite: 170]. [cite_start]Includes a comparative **Big O runtime analysis** for methods like `add()`, `getMax()`, `reverse()`, and `removeDuplicates()`[cite: 196, 204]. |
| **Concepts** | **Interfaces**, **Generics**, **ArrayLists**, **LinkedLists**, **Big O Notation** (Runtime Analysis), **Time/Space Efficiency**. |

**Visual:** 

---

### 4. 💣 Minefield (Minesweeper Clone) (Project 4)

| Detail | Description |
| :--- | :--- |
| **Goal** | Apply **Stack** and **Queue** data structures to solve complex recursive/iterative traversal problems. |
| **Description** | [cite_start]An implementation of the classic Minesweeper game, utilizing two distinct algorithms—DFS and BFS—to handle board revelations[cite: 295, 311]. |
| **Key Features** | [cite_start]Uses a **Queue** (Breadth-First Search/BFS) in `revealStartingArea()` to safely reveal an initial area of the board until a mine is found[cite: 444, 451]. [cite_start]Uses a **Stack** (Depth-First Search/DFS) in `revealZeroes()` to recursively reveal all surrounding empty squares[cite: 411, 419]. [cite_start]Terminal output is enhanced using **ANSI Color Codes** for a dynamic user experience[cite: 467, 484]. |
| **Concepts** | **Stacks**, **Queues**, **Breadth-First Search (BFS)**, **Depth-First Search (DFS)**, **2D Arrays**. |

**Visual:** 

---

This README is now ready to be placed in your main repository!

Would you like me to draft a short section on **how to compile and run** these Java projects locally?
