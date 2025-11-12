### **Problem**

Given an array `arr`, **reverse it in-place** using **two pointers**.

**Constraint:** Do not use extra space for another array.

---

### **Approach: Two Pointers (Start & End)**

1. **Start pointer** `start` → begins at index 0.
2. **End pointer** `end` → begins at the last index `arr.length - 1`.
3. Swap `arr[start]` and `arr[end]`.
4. Move `start` forward (`start++`) and `end` backward (`end--`).
5. Repeat until `start >= end`.

✅ **Time Complexity:** O(n/2) → O(n)
✅ **Space Complexity:** O(1) (in-place)

---

### **Java Code Example**

```java
public class ReverseArray {
    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            // swap arr[start] and arr[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);
        
        System.out.print("Reversed array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

**Output:**

```
Reversed array: 5 4 3 2 1
```

---

### **Explanation**

* **Pointers:**
  `start = 0`, `end = arr.length - 1`

* **Steps:**

```
arr = [1, 2, 3, 4, 5]
start=0, end=4 -> swap 1 & 5 -> [5, 2, 3, 4, 1]
start=1, end=3 -> swap 2 & 4 -> [5, 4, 3, 2, 1]
start=2, end=2 -> pointers meet -> stop
```

* The array is now **reversed in-place**.

* This approach is **very efficient** because it uses only **O(1) extra space** and **linear time**.

---
