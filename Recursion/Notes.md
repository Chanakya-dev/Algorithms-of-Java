## **Recursion in Programming**

### **Definition**

Recursion is a programming technique where a function calls itself directly or indirectly to solve a problem. It's used to break a complex problem into smaller, more manageable sub-problems of the same type.

---

### **Key Concepts**

1. **Base Case**

   * The condition under which the recursive function stops calling itself.
   * Without a base case, recursion can lead to infinite calls and **stack overflow**.

2. **Recursive Case**

   * The part of the function where the problem is divided into smaller sub-problems.
   * Typically, it involves calling the same function with modified arguments.

3. **Call Stack**

   * Each recursive call is stored on the **call stack** until the base case is reached.
   * Once the base case is satisfied, the stack **unwinds**, returning results to previous calls.

---

### **Advantages**

* Simplifies code for problems that have natural recursive structures (like trees, graphs, and combinatorial problems).
* Makes complex problems easier to conceptualize.

### **Disadvantages**

* Can be memory-intensive due to the call stack.
* Sometimes iterative solutions are more efficient.
* Risk of stack overflow if recursion depth is too large.

---

### **Recursion Patterns**

1. **Linear Recursion**

   * A function makes a single recursive call each time.
   * Example: Factorial, Fibonacci (simple version)

2. **Tail Recursion**

   * The recursive call is the **last statement** in the function.
   * Can be optimized by the compiler (Tail Call Optimization).

3. **Tree Recursion**

   * A function makes **multiple recursive calls** each time.
   * Example: Fibonacci (naive version), generating permutations.

4. **Indirect Recursion**

   * Function A calls function B, and function B calls function A (or another sequence).

5. **Nested/Mutual Recursion**

   * Multiple functions calling each other in a cycle.

---

### **Common Recursive Problems**

* Factorial of a number
* Fibonacci series
* Reverse a string
* Sum of array elements
* Tower of Hanoi
* Permutations and combinations
* Binary tree traversals (preorder, inorder, postorder)
* Graph traversal (DFS)
* Solving puzzles like N-Queens, Maze problems

---

### **Steps to Approach a Recursive Problem**

1. Identify **base case(s)**.
2. Identify **recursive case(s)**.
3. Determine how the problem reduces in each recursive step.
4. Ensure **progression** towards the base case.
5. Think about **return values** and how they combine.

---

### **Tips for Writing Recursion**

* Always **think in terms of smaller problems**.
* Trace with **small input examples** to visualize recursion.
* Use **helper functions** if needed to manage extra parameters.
* Consider **memoization** for overlapping subproblems to optimize time.

---
