## **Problem Statement**

Given an array of integers `arr` and an integer `k`, **check if the array contains duplicates such that the distance between the duplicates is at most k**.

Formally:

* Check if there exist indices `i` and `j` such that:

  * `arr[i] == arr[j]`
  * `|i - j| <= k`

**Example 1:**

```text
Input: arr = [1, 2, 3, 1], k = 3
Output: true
Explanation: arr[0] == arr[3] and 3 - 0 <= 3
```

**Example 2:**

```text
Input: arr = [1, 2, 3, 1, 2, 3], k = 2
Output: false
Explanation: No duplicates within distance 2
```

---

## **Solution Approach**

We can solve this efficiently using a **sliding window + HashSet**:

1. **Maintain a HashSet** to store elements in the current window of size at most `k`.
2. Iterate through the array:

   * If the element is already in the set → **duplicate within k distance found**, return true.
   * Add the element to the set.
   * If the set size exceeds `k`, remove the element at index `i-k` (slide the window).
3. If no duplicates found in all windows → return false.

> ⚡ **Time Complexity:** O(n)
> ⚡ **Space Complexity:** O(k)

---

### **Java Solution**

```java
import java.util.*;

public class DuplicateWithinK {
    public static boolean containsNearbyDuplicate(int[] arr, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (window.contains(arr[i])) {
                return true; // duplicate within distance k found
            }
            window.add(arr[i]);

            if (window.size() > k) {
                window.remove(arr[i - k]); // slide the window
            }
        }

        return false; // no duplicates within distance k
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,1};
        int[] arr2 = {1,2,3,1,2,3};

        System.out.println(containsNearbyDuplicate(arr1, 3)); // true
        System.out.println(containsNearbyDuplicate(arr2, 2)); // false
    }
}
```

---

### **Python Solution**

```python
def contains_nearby_duplicate(arr, k):
    window = set()

    for i, num in enumerate(arr):
        if num in window:
            return True  # duplicate within distance k found
        window.add(num)

        if len(window) > k:
            window.remove(arr[i - k])  # slide the window

    return False

# Examples
arr1 = [1,2,3,1]
arr2 = [1,2,3,1,2,3]

print(contains_nearby_duplicate(arr1, 3))  # True
print(contains_nearby_duplicate(arr2, 2))  # False
```

---

### **Explanation**

* We maintain a **sliding window of the last `k` elements** using a HashSet.

* As we iterate:

  1. Check if the current element exists in the window → duplicate within `k` distance.
  2. Add the current element to the window.
  3. If window size > k, remove the element that is now **out of range**.

* This ensures we **only track elements within distance `k`** efficiently.

---

✅ **Key Interview Notes:**

* Classic **sliding window + hash set** problem.
* Optimized: O(n) time, O(k) space.
* Variations:

  * Return **indices** of duplicates.
  * Count **number of duplicates** within distance k.
  * Works with **strings or other hashable types**.
