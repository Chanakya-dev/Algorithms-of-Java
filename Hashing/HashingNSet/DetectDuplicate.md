## **Problem Statement**

Given an array of integers, **check if there are any duplicates**.

**Example 1:**

```text
Input: arr = [1, 2, 3, 4, 5]
Output: false
Explanation: All elements are unique
```

**Example 2:**

```text
Input: arr = [1, 2, 3, 2]
Output: true
Explanation: 2 appears twice
```

---

## **Solution Approach**

We can solve this efficiently using **hashing**:

1. **Use a HashSet** to keep track of elements we have seen.
2. **Iterate** through the array:

   * If the current element is already in the set → **duplicate found**, return true.
   * Otherwise, add the element to the set.
3. If we finish iterating without finding duplicates → return false.

> ⚡ **Time Complexity:** O(n)
> ⚡ **Space Complexity:** O(n)

---

### **Java Solution**

```java
import java.util.*;

public class DetectDuplicates {
    public static boolean hasDuplicate(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(num)) {
                return true; // duplicate found
            }
            seen.add(num);
        }

        return false; // no duplicates
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 2};

        System.out.println(hasDuplicate(arr1)); // false
        System.out.println(hasDuplicate(arr2)); // true
    }
}
```

---

### **Python Solution**

```python
def has_duplicate(arr):
    seen = set()
    for num in arr:
        if num in seen:
            return True  # duplicate found
        seen.add(num)
    return False  # no duplicates

# Examples
arr1 = [1,2,3,4,5]
arr2 = [1,2,3,2]

print(has_duplicate(arr1))  # False
print(has_duplicate(arr2))  # True
```

---

### **Explanation**

1. **HashSet / set** stores elements we have already seen.
2. Iterating through the array:

   * **arr = [1,2,3,2]**

     * Step 1: 1 → not in set → add → set = {1}
     * Step 2: 2 → not in set → add → set = {1,2}
     * Step 3: 3 → not in set → add → set = {1,2,3}
     * Step 4: 2 → already in set → duplicate found → return true
3. If no element repeats → return false.

✅ **Key Points for Interviews:**

* **Optimal solution:** O(n) time, O(n) space.
* **Alternative approach (no extra space):** Sort array and check consecutive elements → O(n log n) time, O(1) space.
* Works for **any hashable elements** (integers, strings).

---
