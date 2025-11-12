### **Problem**

Given an array `arr` and an integer `k`, find the **length of the longest contiguous subarray** that contains **at most `k` distinct elements**.

**Example:**

```
arr = [1,2,1,2,3], k = 2
Longest subarray = [1,2,1,2], length = 4
```

---

### **Approach: Sliding Window + HashMap**

We can use a **two-pointer (sliding window)** approach:

1. **Left pointer (`left`)** → start of the current window.
2. **Right pointer (`right`)** → expand the window by moving forward.
3. **HashMap** → keeps track of the **frequency of elements** in the current window.

**Steps:**

1. Initialize `left = 0`, `maxLen = 0`, and an empty `Map<Integer, Integer>`.
2. Move `right` from `0` to `arr.length-1`.
3. Add `arr[right]` to the map (increase frequency).
4. **Check if distinct count > k**:

   * If yes, shrink the window from the left (`left++`) and update frequencies in the map.
   * Remove elements from the map when frequency becomes 0.
5. Update `maxLen = max(maxLen, right - left + 1)`.
6. Return `maxLen`.

---

### **Java Code Example**

```java
import java.util.*;

public class LongestSubarrayKDistinct {
    public static int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < arr.length; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);
            
            while (freqMap.size() > k) {
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if (freqMap.get(arr[left]) == 0) {
                    freqMap.remove(arr[left]);
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        int k = 2;
        System.out.println("Longest subarray length: " + longestSubarray(arr, k)); // 4
    }
}
```

---

### **Explanation**

* Use a **sliding window** `[left, right]`.
* Expand `right` → include new elements.
* If the window contains **> k distinct elements**, shrink from `left`.
* Keep track of **maximum window length** that satisfies `<= k` distinct elements.

**Walkthrough Example:**

```
arr = [1,2,1,2,3], k = 2
right=0, arr[0]=1 -> map={1:1}, maxLen=1
right=1, arr[1]=2 -> map={1:1,2:1}, maxLen=2
right=2, arr[2]=1 -> map={1:2,2:1}, maxLen=3
right=3, arr[3]=2 -> map={1:2,2:2}, maxLen=4
right=4, arr[4]=3 -> map={1:2,2:2,3:1} -> size>k
shrink left: left=0 -> map={1:1,2:2,3:1} -> still > k
shrink left: left=1 -> map={1:1,2:2,3:1} -> still > k
shrink left: left=2 -> map={1:0,2:2,3:1} -> remove 1 -> map={2:2,3:1}
maxLen=4 (unchanged)
```

* ✅ Result: **4**

---

### **Time Complexity**

* O(n) → Each element is processed at most twice (once by `right`, once by `left`).
* O(k) space → HashMap holds at most `k` distinct elements.
