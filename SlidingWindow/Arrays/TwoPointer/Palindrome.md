### **Problem**

Given an array `arr`, check if it reads the same **forward and backward**.

* If yes → it is a **palindrome**.
* If not → it is **not a palindrome**.

**Constraint:** Do it **in-place** with **O(1) extra space**.

---

### **Approach: Two Pointers (Start & End)**

1. **Start pointer** `start` → begins at index 0.
2. **End pointer** `end` → begins at the last index `arr.length - 1`.
3. Compare `arr[start]` with `arr[end]`.

   * If they are **not equal**, return false → array is not a palindrome.
   * If they are equal, move `start++` and `end--`.
4. Repeat until `start >= end`.
5. If all comparisons pass → array is a palindrome.

✅ **Time Complexity:** O(n/2) → O(n)
✅ **Space Complexity:** O(1)

---

### **Java Code Example**

```java
public class PalindromeArray {
    public static boolean isPalindrome(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false; // mismatch found
            }
            start++;
            end--;
        }
        
        return true; // all matched
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 1};
        int[] arr2 = {1, 2, 3, 4, 5};
        
        System.out.println("arr1 is palindrome? " + isPalindrome(arr1)); // true
        System.out.println("arr2 is palindrome? " + isPalindrome(arr2)); // false
    }
}
```

---

### **Explanation**

* **Pointers:**
  `start = 0`, `end = arr.length - 1`

* **Steps (Example arr = [1, 2, 3, 2, 1]):**

```
start=0, end=4 -> arr[0]=1, arr[4]=1 -> equal -> move pointers
start=1, end=3 -> arr[1]=2, arr[3]=2 -> equal -> move pointers
start=2, end=2 -> pointers meet -> stop
All matched -> palindrome
```

* **Example arr = [1, 2, 3, 4, 5]:**

```
start=0, end=4 -> arr[0]=1, arr[4]=5 -> not equal -> return false
```

✅ Efficient because it uses **linear time** and **no extra space**.
