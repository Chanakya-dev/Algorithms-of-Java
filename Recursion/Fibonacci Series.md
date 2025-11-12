## **Fibonacci Series / nth Fibonacci Number**

### **Definition**

The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, starting from 0 and 1.

[
F_0 = 0, \quad F_1 = 1
]

[
F_n = F_{n-1} + F_{n-2}, \quad n \ge 2
]

---

### **Series Example**

* First 10 Fibonacci numbers:
  `0, 1, 1, 2, 3, 5, 8, 13, 21, 34`

* Example: To calculate (F_5):
  [
  F_5 = F_4 + F_3 = (3) + (2) = 5
  ]

---

## **Recursive Approach**

### **Idea**

Use the **definition directly**:

* Base cases: (F_0 = 0), (F_1 = 1)
* Recursive case: (F_n = F_{n-1} + F_{n-2})

### **Code (Java)**

```java
public class Fibonacci {
    public static int fib(int n) {
        if (n == 0) return 0; // base case
        if (n == 1) return 1; // base case
        return fib(n-1) + fib(n-2); // recursive call
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci(" + n + ") = " + fib(n)); // Output: 5
    }
}
```

### **Step-by-Step Execution for fib(5)**

```
fib(5)
= fib(4) + fib(3)
= (fib(3)+fib(2)) + (fib(2)+fib(1))
= ((fib(2)+fib(1)) + (fib(1)+fib(0))) + ((fib(1)+fib(0))+1)
...
= 5
```

**Problem:**

* The plain recursion **recomputes the same subproblems** multiple times.
* Time Complexity: **O(2^n)** → inefficient for large n.

---

## **Optimized Approach: Recursion + Memoization**

### **Idea**

* Store already computed Fibonacci numbers in an array (or map).
* Avoid recomputation, reducing time complexity to **O(n)**.

### **Code (Java)**

```java
public class Fibonacci {
    public static int fib(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != -1) return memo[n]; // check if already computed

        memo[n] = fib(n-1, memo) + fib(n-2, memo); // store result
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println("Fibonacci(" + n + ") = " + fib(n, memo)); // Output: 55
    }
}
```

**Time Complexity:** O(n)
**Space Complexity:** O(n) (for memo + recursion stack)

---

## **Iterative / Dynamic Programming Approach**

* Avoid recursion altogether
* Use **bottom-up approach**

```java
public class Fibonacci {
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0, prev1 = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci(" + n + ") = " + fib(n)); // Output: 55
    }
}
```

* **Time Complexity:** O(n)
* **Space Complexity:** O(1) → very efficient

---

## **Key Points**

1. Fibonacci is a **classic recursion problem** used to teach recursion + memoization.
2. Plain recursion → exponential time, not practical for large n.
3. Memoization → store intermediate results → linear time.
4. Iterative / DP approach → most efficient in both time and space.
5. Variants of Fibonacci questions are often asked in interviews:

   * Nth Fibonacci
   * Print first N Fibonacci numbers
   * Fibonacci modulo some number
   * Sum of first N Fibonacci numbers
   * Using matrix exponentiation for O(log n) solution
