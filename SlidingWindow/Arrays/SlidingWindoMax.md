### **Problem**

Given an array `arr` and a window size `k`, find the **maximum in every contiguous subarray (window) of size `k`**.

**Example:**

```
arr = [1,3,-1,-3,5,3,6,7], k = 3
Output = [3,3,5,5,6,7]
```

---

### **Approach: Deque + Sliding Window**

Since **finding the max in every window naively** is O(n*k), we can optimize using a **deque** (double-ended queue):

1. The **deque stores indices** of elements in the current window.
2. Elements in deque are **in decreasing order** (largest at the front).
3. **Rules for deque:**

   * Remove indices from **front** if they are **out of the current window**.
   * Remove indices from **back** if `arr[i] >= arr[deque.back()]` → maintain decreasing order.
4. The **front of deque** always has the **maximum for the current window**.

✅ **Time Complexity:** O(n)
✅ **Space Complexity:** O(k)

---

### **Java Code Example**

```java
import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr.length == 0) return new int[0];
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove indices out of current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove smaller elements from back
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.pollLast();
            }
            
            deque.offerLast(i); // add current index
            
            // Window of size k formed
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(res)); // [3, 3, 5, 5, 6, 7]
    }
}
```

---

### **Explanation**

* **Deque stores indices in decreasing order of values.**
* **Front of deque = maximum of current window.**
* **For each element `arr[i]`:**

  1. Remove indices from **front** if they are outside the window (`i - k + 1`).
  2. Remove indices from **back** if `arr[i] >= arr[deque.back()]` → they can't be max anymore.
  3. Add `i` to back of deque.
  4. If window formed (`i >= k-1`), add `arr[deque.front()]` to result.

**Walkthrough Example (first few steps):**

```
arr = [1,3,-1,-3,5,3,6,7], k = 3
i=0: deque=[0]
i=1: arr[1]=3 >= arr[0]=1 -> remove 0 -> deque=[1]
i=2: arr[2]=-1 < arr[1]=3 -> deque=[1,2]
window formed -> result[0]=arr[1]=3
i=3: remove out-of-window index 1? No, 1 in window
remove smaller than arr[3]=-3? none
deque=[1,2,3]
window formed -> result[1]=arr[1]=3
...
```
