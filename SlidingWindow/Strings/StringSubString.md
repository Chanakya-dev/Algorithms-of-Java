### **Problem**

Given two strings `s` and `t`, find the **smallest substring of `s`** that **contains all characters of `t`** (including multiplicities).

**Example:**

```
s = "ADOBECODEBANC"
t = "ABC"
Output = "BANC"
```

---

### **Approach: Sliding Window + HashMap + Two Pointers**

1. **Count characters in `t`** using a HashMap (`targetMap`).
2. Use **two pointers**:

   * `left` → start of the window
   * `right` → end of the window
3. Expand `right` to include characters in `s`:

   * Maintain a `windowMap` to count characters in the current window.
4. **Check if the window is valid**:

   * Window is valid if it contains **all characters of `t`** with required frequency.
5. If valid, try **shrinking from left** to get the **smallest window**:

   * Remove `s[left]` from `windowMap` and move `left++`.
   * Stop shrinking when window is no longer valid.
6. Track the **minimum length window** and its start index.

✅ **Time Complexity:** O(n + m), n = length of `s`, m = length of `t`
✅ **Space Complexity:** O(n + m)

---

### **Java Code Example**

```java
import java.util.*;

public class MinWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int required = targetMap.size();
        int formed = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }
            
            // Try shrinking the window
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + minWindow(s, t)); // "BANC"
    }
}
```

---

### **Explanation**

* **Pointers:**

  * `left` → start of current window
  * `right` → end of current window

* **Steps (Example s = "ADOBECODEBANC", t = "ABC"):**

```
right=0: 'A', windowMap={'A':1} -> formed=1
right=1: 'D', windowMap={'A':1,'D':1} -> formed=1
right=2: 'O', windowMap={'A':1,'D':1,'O':1} -> formed=1
right=3: 'B', windowMap={'A':1,'D':1,'O':1,'B':1} -> formed=2
right=4: 'E', windowMap={'A':1,'D':1,'O':1,'B':1,'E':1} -> formed=2
right=5: 'C', windowMap={'A':1,'D':1,'O':1,'B':1,'E':1,'C':1} -> formed=3 (all chars covered)
Shrink from left to minimize window -> window="ADOBEC" length=6
Continue scanning...
Final min window = "BANC"
```

* **Key Idea:**

  * Maintain a **sliding window** that contains all required characters.
  * **Expand right** to include characters, **shrink left** to minimize window.
  * Track **smallest valid window** during the process.

---
