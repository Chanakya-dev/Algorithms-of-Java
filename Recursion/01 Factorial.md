## **Factorial of a Number**

### **Definition**

The factorial of a non-negative integer ( n ) (denoted ( n! )) is the product of all positive integers less than or equal to ( n ).

Mathematically:

[
n! = n \times (n-1) \times (n-2) \times \dots \times 1
]

**Special case:**

[
0! = 1
]

---

### **Example**

* (5! = 5 \times 4 \times 3 \times 2 \times 1 = 120)
* (3! = 3 \times 2 \times 1 = 6)
* (0! = 1)

---

### **Recursive Approach**

**Idea:**

[
n! = n \times (n-1)!
]

* **Base case:** (0! = 1)
* **Recursive case:** (n! = n \times (n-1)!)

---

### **Code Example (Java)**

```java
public class Factorial {
    public static int factorial(int n) {
        if (n == 0) return 1; // Base case
        return n * factorial(n - 1); // Recursive case
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(num + "! = " + factorial(num)); // Output: 120
    }
}
```

---

### **Step-by-Step Execution for 5!**

1. `factorial(5)` → `5 * factorial(4)`
2. `factorial(4)` → `4 * factorial(3)`
3. `factorial(3)` → `3 * factorial(2)`
4. `factorial(2)` → `2 * factorial(1)`
5. `factorial(1)` → `1 * factorial(0)`
6. `factorial(0)` → `1` (base case reached)

Now the stack **unwinds**:

[
1 * 1 = 1
2 * 1 = 2
3 * 2 = 6
4 * 6 = 24
5 * 24 = 120
]

---

### **Key Points**

* Factorial is a **linear recursion** problem (single recursive call).
* Recursive solution is elegant but **can cause stack overflow** for large ( n ).
* Iterative solutions are safer for very large numbers.

---
