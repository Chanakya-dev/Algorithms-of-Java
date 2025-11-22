## **Problem:**

Given an array, find the **element that occurs most frequently**.

Example:

```text
Input: [1, 3, 2, 3, 4, 1, 3]
Output: 3
Explanation: 3 appears 3 times, which is more than any other element.
```

---

## **Solution Approach Using Hashing**

### **Step 1: Count frequencies**

* Use a **HashMap** (or dictionary in Python) to count occurrences of each element.
* Key = element, Value = count

### **Step 2: Find maximum frequency**

* Iterate through the map to find the element with the highest count.
* Keep track of `maxCount` and `modeElement`.

### **Step 3: Return the mode**

* Return the element that appears most frequently.

---

## **Java Implementation**

```java
import java.util.*;

public class ModeOfArray {

    public static int findMode(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find element with maximum frequency
        int mode = arr[0]; // default to first element
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }

        return mode;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 4, 1, 3};
        System.out.println("Mode of the array: " + findMode(arr));
    }
}
```

**Output:**

```
Mode of the array: 3
```

2. **Finding the mode:**

   * Start with `maxCount = 0` and `mode = first element`.
   * Compare each element's frequency:

     * 1 → count = 2 → maxCount = 2, mode = 1
     * 3 → count = 3 → maxCount = 3, mode = 3
     * 2 → count = 1 → skip
     * 4 → count = 1 → skip
   * Result → **mode = 3**

---

### **Time and Space Complexity**

| Operation            | Complexity        |
| -------------------- | ----------------- |
| Counting frequencies | O(n)              |
| Finding maximum      | O(n)              |
| **Overall**          | O(n)              |
| Space                | O(n) for hash map |

---

**Key Notes:**

* If multiple elements have the same maximum frequency, this method returns the **first one encountered** with that frequency.
* This method works for **any hashable elements** (integers, strings, etc.).
* You can also solve it using **sorting**, but hashing gives **linear time O(n)** instead of O(n log n).

---
