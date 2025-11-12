### **Problem**

Given an array `arr` of **positive integers** and a **target sum**, find the **length of the smallest contiguous subarray** whose sum is **greater than or equal to the target**.

**Example:**

```
arr = [2,3,1,2,4,3], target = 7
Smallest subarray = [4,3], length = 2
```

---

### **Approach: Sliding Window (Two Pointers)**

Since all elements are **positive**, we can use a **sliding window**:

1. **Left pointer (`left`)** → start of the current window.
2. **Right pointer (`right`)** → expands the window.
3. Keep a running **sum of elements** in the window.

**Steps:**

1. Initialize `left = 0`, `sum = 0`, `minLen = Integer.MAX_VALUE`.
2. Move `right` from `0` to `arr.length-1`:

   * Add `arr[right]` to `sum`.
   * While `sum >= target`:

     * Update `minLen = Math.min(minLen, right - left + 1)`.
     * Shrink window from left: `sum -= arr[left]`, `left++`.
3. After the loop, if `minLen` was updated → return it; otherwise return `0` (no such subarray exists).

✅ **Time Complexity:** O(n)
✅ **Space Complexity:** O(1)

---

### **Java Code Example**

```java
public class MinSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] arr) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }
        
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        System.out.println("Minimum size subarray length: " + minSubArrayLen(target, arr)); // 2
    }
}
```

---

### **Explanation**

* **Pointers:**

  * `left` → start of window
  * `right` → end of window
* **Running sum** keeps track of the total in the current window.
* Expand `right` to include elements until `sum >= target`.
* Shrink `left` as much as possible while maintaining `sum >= target` → ensures smallest subarray.

**Walkthrough Example:**

```
arr = [2,3,1,2,4,3], target=7
right=0 -> sum=2 < 7 -> continue
right=1 -> sum=5 < 7 -> continue
right=2 -> sum=6 < 7 -> continue
right=3 -> sum=8 >= 7 -> update minLen=4, shrink left: sum=6, left=1
right=4 -> sum=10 >=7 -> minLen=4, shrink left: sum=7, left=2 -> minLen=3
shrink left: sum=6, left=3
right=5 -> sum=9 >=7 -> minLen=3, shrink left: sum=7, left=4 -> minLen=2
shrink left: sum=3 <7 -> stop
```

✅ Result: **2** → `[4,3]`

---

If you want, I can **also give a variant where the array can have negative numbers**, which requires a **different approach** using a **deque**.

Do you want me to explain that too?
