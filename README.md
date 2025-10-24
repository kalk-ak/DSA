# 🚀 Data Structures & Algorithms Journey

[![Language](https://img.shields.io/badge/Language-Java-orange.svg)](#)

---

## 👋 Welcome!

This repository is my personal archive, tracking my learning progression through **Data Structures and Algorithms** (DSA) from various courses and resources. It's where I keep all the projects, labs, exercises, and fundamental implementations I've worked on.

---

## 💡 Core Concepts Explored

The projects here focus on building and using key areas of computer science. Here's a look at the main concepts I've been focusing on:

* **Linear Structures:** Arrays, **Linked Lists**, **Stacks**, **Queues**, and Priority Queues.
* **Non-Linear Structures:** Trees, Binary Search Trees, Heaps, Maps, and Hash Tables.
* **Algorithmic Analysis:** Getting practice with **Big O notation** to analyze the time and space efficiency of my code.
* **Fundamental Principles:** **Recursion**, generics, and core object-oriented design patterns.

---

## 🛠️ Key Projects Portfolio

This section highlights four of the main projects I've built, showing how I've applied the concepts above.

### 1. 🎨 Fractal Drawer (Project 1)

| Detail | Description |
| :--- | :--- |
| **Goal** | Use OOP principles and recursion to draw complex geometric patterns. |
| **Description** | I built an application that uses **recursion** to generate and draw intricate **fractal patterns** from circles, triangles, and rectangles. The recursive function repeatedly draws smaller shapes based on the position and size of the previous ones. |
| **Key Features** | Implemented three foundational shape classes (`Circle.java`, `Triangle.java`, `Rectangle.java`). A key requirement was making the fractal repeat at least 7 times, using a new color for each layer. |
| **Concepts** | **Object-Oriented Programming (OOP)**, **Classes and Methods**, **Recursion**, **Geometric Calculations**. |

**Visual:**

---

### 2. ♟️ Simplified Chess Game (Project 2)

| Detail | Description |
| :--- | :--- |
| **Goal** | Use **2D arrays** and **polymorphism** to model and enforce game rules. |
| **Description** | This is a command-line implementation of a simplified two-player chess game. I wrote the game logic to manage the board state, piece movement, and enforce the standard rules for all pieces. |
| **Key Features** | The board is represented by a **2D array of `Piece` objects** (`Board.java`). I implemented the full movement legality checks for the Rook, Knight, Bishop, Queen, and King. For the display, I used **Unicode characters** to show the pieces in the terminal. |
| **Concepts** | **2D Arrays**, **Inheritance/Polymorphism**, **Object-Oriented Design**, **Terminal I/O**. |

**Visual:**

---

### 3. 🔗 Custom Lists: ArrayList vs. LinkedList (Project 3)

| Detail | Description |
| :--- | :--- |
| **Goal** | Implement and compare the core functionality and runtime of two primary linear data structures. |
| **Description** | In this project, I built both a **dynamic array-backed list** (`ArrayList`) and a **generic node-based list** (`LinkedList`) from scratch. It was a great way to compare the different mechanisms of these two structures. |
| **Key Features** | Both of my custom classes implement the generic `List<T>` interface. My `ArrayList` handles **dynamic resizing** by doubling its length when full. I also included a comparative **Big O runtime analysis** for common methods like `add()`, `getMax()`, `reverse()`, and `removeDuplicates()`. |
| **Concepts** | **Interfaces**, **Generics**, **ArrayLists**, **LinkedLists**, **Big O Notation** (Runtime Analysis), **Time/Space Efficiency**. |

**Visual:**

---

### 4. 💣 Minefield (Minesweeper Clone) (Project 4)

| Detail | Description |
| :--- | :--- |
| **Goal** | Apply **Stack** and **Queue** data structures to solve complex traversal problems. |
| **Description** | I created a clone of the classic Minesweeper game. The main challenge was using two different algorithms—DFS and BFS—to handle revealing the board. |
| **Key Features** | I used a **Queue** (for a Breadth-First Search) to implement the `revealStartingArea()` function, which safely uncovers an initial patch of the board. I then used a **Stack** (for a Depth-First Search) in `revealZeroes()` to recursively clear all surrounding empty squares. I also added **ANSI Color Codes** to make the terminal output more dynamic. |
| **Concepts** | **Stacks**, **Queues**, **Breadth-First Search (BFS)**, **Depth-First Search (DFS)**, **2D Arrays**. |

**Visual:**

---
