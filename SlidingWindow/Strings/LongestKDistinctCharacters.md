### **Problem**

Given a string `s` and an integer `K`, find the **length of the longest substring** that contains **at most `K` distinct characters**.

**Example:**

```
s = "eceba", K = 2
Output = 3  // substring "ece"
```

---

### **Approach: Sliding Window + HashMap**

We can solve this efficiently using a **sliding window**:

1. Use **two pointers**:

   * `left` → start of the current window
   * `right` → end of the current window
2. Use a **HashMap** to store **character frequencies** in the current window.
3. Expand `right` to include characters:

   * Add/update `s[right]` frequency in the map.
4. If **distinct character count > K**:

   * Shrink the window from the left (`left++`) and **decrease frequency** of `s[left]` in the map.
   * Remove characters from the map if their frequency becomes 0.
5. Update `maxLen = max(maxLen, right - left + 1)` at each step.

✅ **Time Complexity:** O(n)
✅ **Space Complexity:** O(K)

---

### **Java Code Example**

```java
import java.util.*;

public class LongestSubstringKDistinct {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0 || k == 0) return 0;
        
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            
            // shrink window if distinct characters > k
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Length of longest substring with at most " + k +
                           " distinct characters: " + lengthOfLongestSubstringKDistinct(s, k)); // 3
    }
}
```

---

### **Explanation**

* **Pointers:**

  * `left` → start of window
  * `right` → end of window
* **Steps (Example s = "eceba", k = 2):**

```
right=0: 'e', map={e:1} -> maxLen=1
right=1: 'c', map={e:1, c:1} -> maxLen=2
right=2: 'e', map={e:2, c:1} -> maxLen=3
right=3: 'b', map={e:2, c:1, b:1} -> size>k -> shrink
    remove 'e'? map={e:1,c:1,b:1} -> size>k -> remove 'c'? map={e:1,b:1} -> left=2
right=4: 'a', map={e:1,b:1,a:1} -> size>k -> shrink
    remove 'e'? map={b:1,a:1} -> left=3
```

* **Result:** Longest substring `"ece"` → length **3**

---

**Key Idea:**

* Use **sliding window** to maintain a substring with **≤ K distinct characters**.
* Use a **map to track frequencies** to know when to shrink the window.
* Update **max length** as you expand the window.

---
