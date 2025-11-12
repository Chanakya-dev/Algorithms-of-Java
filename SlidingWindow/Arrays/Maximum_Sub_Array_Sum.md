## **Problem 1: Maximum Sum Subarray of Size `k`**

**Problem Statement:**
You are given an array of integers `arr[]` and an integer `k`. Find the **maximum sum** of any contiguous subarray of size `k`.

**Example:**

```
arr = [2, 1, 5, 1, 3, 2]
k = 3
```

**Output:** `9`
**Explanation:** The subarray `[5, 1, 3]` has the maximum sum `9`.

---

### **Step 1: Brute Force Approach**

* Check every subarray of size `k`.
* Calculate sum of each subarray.
* Keep track of the maximum sum.

**Time Complexity:** `O(n*k)` → inefficient for large arrays.

---

### **Step 2: Sliding Window Approach (Optimal)**

**Idea / Intuition:**

* Instead of recalculating sum for every window from scratch, we **reuse the previous sum**.
* When moving the window by one element to the right:

  ```
  new_sum = old_sum + arr[i] - arr[i-k]
  ```
* This removes the leftmost element of the old window and adds the new rightmost element.

**Advantages:**

* Time Complexity: `O(n)`
* Space Complexity: `O(1)`

---

### **Step 3: Algorithm**

1. Initialize `sum` to the sum of first `k` elements.
2. Set `maxSum = sum`.
3. For each element from index `k` to `n-1`:

   * Slide the window: `sum = sum + arr[i] - arr[i-k]`
   * Update `maxSum` if `sum > maxSum`
4. Return `maxSum`.

---

### **Step 4: Java Code**

```java
public class MaxSumSubarray {
    public static int maxSum(int[] arr, int k) {
        int n = arr.length;
        if(n < k) return -1; // Edge case

        // Step 1: Sum of first window
        int sum = 0;
        for(int i = 0; i < k; i++) sum += arr[i];
        int maxSum = sum;

        // Step 2: Slide the window
        for(int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k]; // Add new element, remove old
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSum(arr, k));
        // Output: 9
    }
}
```

---

### **Step 5: Key Points to Remember**

1. Always calculate the **initial window sum** first.
2. Slide the window by removing the **first element** of the previous window and adding the **next element**.
3. Update **maximum (or minimum)** as needed.
4. Time Complexity = `O(n)` and Space Complexity = `O(1)`.

---
