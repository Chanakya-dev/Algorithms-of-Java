### **Problem**

Given a string `s`, find the **length of the longest substring** that contains **all unique characters** (no repeats).

**Example:**

```
s = "abcabcbb"
Output = 3  // substring "abc"
```

---

### **Approach: Sliding Window + Set/Map**

1. Use **two pointers**:

   * `left` → start of the current window
   * `right` → end of the current window
2. Use a **HashSet** to keep track of **characters in the current window**.
3. Expand `right`:

   * If `s[right]` is **not in the set**, add it to the set, update `maxLen = max(maxLen, right - left + 1)`.
   * If `s[right]` **already exists**, shrink the window from the left (`remove s[left]` from set, `left++`) until `s[right]` can be added.
4. Repeat until `right` reaches the end of the string.

✅ **Time Complexity:** O(n)
✅ **Space Complexity:** O(min(n, charset))

---

### **Java Code Example**

```java
import java.util.*;

public class LongestUniqueSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters: " +
                           lengthOfLongestSubstring(s)); // 3
    }
}
```

---

### **Explanation**

* **Pointers:**

  * `left` → start of the window
  * `right` → end of the window
* **Steps:**

```
s = "abcabcbb"
right=0: 'a' not in set -> add -> maxLen=1
right=1: 'b' not in set -> add -> maxLen=2
right=2: 'c' not in set -> add -> maxLen=3
right=3: 'a' in set -> remove s[left]='a', left=1 -> add 'a'
right=4: 'b' in set -> remove s[left]='b', left=2 -> add 'b'
...
```

* **Result:** longest substring `"abc"` → length **3**

---

**Key Idea:**

* Use a **sliding window** to maintain the current substring with **unique characters**.
* Expand `right` to include new characters and shrink from `left` when duplicates appear.
* Track **maximum length** seen so far.
