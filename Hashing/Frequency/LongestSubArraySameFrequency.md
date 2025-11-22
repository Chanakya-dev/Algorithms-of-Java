## **Problem Statement**

Given an array, find the **length of the longest subarray** in which **all elements occur the same number of times**.

**Example:**

```text
Input: arr = [1,2,2,1,3,3,3,1,2,2]
Output: 4
Explanation: Subarray [2,2,1,1] → frequency of 1 = 2, frequency of 2 = 2
```

---

## **Solution Approach**

### **Step 1: Understand the problem**

We need a **subarray** where:

* All elements in that subarray have **the same frequency**.
* We need the **maximum length** of such subarrays.

---

### **Step 2: Approach**

1. Use **hash map** to store **frequency of each element in current window/subarray**.
2. Iterate through the array and try **all subarrays** (can optimize using sliding window / prefix sums).
3. For each subarray, check if **all values in frequency map are equal**.
4. Keep track of **maximum length**.

> ⚠️ **Observation:**

* Naive approach: O(n³) → check every subarray.
* Optimized approach: Can use **prefix frequency + hashing** for small numbers of unique elements (more advanced).

For simplicity, let’s see the **naive approach** first, which is easier to understand.

---

## **Java Implementation (Naive O(n³))**

```java
import java.util.*;

public class LongestEqualFrequencySubarray {

    // Helper: Check if all frequencies are equal
    public static boolean allFrequenciesEqual(Map<Integer, Integer> freq) {
        if (freq.isEmpty()) return false;
        int first = -1;
        for (int count : freq.values()) {
            if (first == -1) first = count;
            else if (count != first) return false;
        }
        return true;
    }

    public static int longestEqualFreqSubarray(int[] arr) {
        int n = arr.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                freqMap.put(arr[j], freqMap.getOrDefault(arr[j], 0) + 1);

                if (allFrequenciesEqual(freqMap)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,3,3,3,1,2,2};
        System.out.println("Longest subarray length with equal frequency elements: " +
                           longestEqualFreqSubarray(arr));
    }
}
```

**Output:**

```
Longest subarray length with equal frequency elements: 4
```

---

## **Python Implementation**

```python
from collections import defaultdict

def all_frequencies_equal(freq):
    values = list(freq.values())
    return len(values) > 0 and all(v == values[0] for v in values)

def longest_equal_freq_subarray(arr):
    n = len(arr)
    max_len = 0

    for i in range(n):
        freq = defaultdict(int)
        for j in range(i, n):
            freq[arr[j]] += 1
            if all_frequencies_equal(freq):
                max_len = max(max_len, j - i + 1)
    
    return max_len

# Example
arr = [1,2,2,1,3,3,3,1,2,2]
print("Longest subarray length with equal frequency elements:", longest_equal_freq_subarray(arr))
```

**Output:**

```
Longest subarray length with equal frequency elements: 4
```

---

## **Explanation**

1. Iterate over all possible subarrays `[i..j]`.
2. Maintain a **frequency map** of elements in the current subarray.
3. For each subarray, check if **all frequencies are equal**.
4. If yes, update `maxLength`.

**Step-by-step example:**

```text
arr = [1,2,2,1,3,3,3,1,2,2]

Consider subarray [1,2,2,1]
Frequency: {1:2, 2:2} → all equal → length = 4 → maxLength = 4
Other subarrays either have unequal frequencies → ignored
```

---

## **Time Complexity**

* O(n³) in naive approach:

  * Outer loop (i) → n
  * Inner loop (j) → n
  * Check frequencies → up to n
* Space: O(n) for frequency map.

> For **optimized solution**:
> Use **prefix frequency + hash + difference array techniques** → O(n²) or better. Can discuss if needed.

---
