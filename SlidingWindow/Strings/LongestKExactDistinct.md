### **Problem**

Given a string `s` and an integer `K`, find the **length of the longest substring** that contains **exactly K distinct characters**.

**Example:**

```
s = "aabacbebebe", K = 3
Output = 7  // substring "cbebebe"
```

---

### **Approach: Sliding Window + HashMap**

1. Use **two pointers**:

   * `left` → start of the window
   * `right` → end of the window
2. Use a **HashMap** to store **character frequencies** in the current window.
3. Expand the window by moving `right`:

   * Add/update `s[right]` frequency in the map.
4. **Shrink the window from left** if distinct character count > K:

   * Decrease frequency of `s[left]`
   * Remove from map if frequency becomes 0
   * Move `left++`
5. **Update maxLen only if distinct characters == K**.

✅ **Time Complexity:** O(n)
✅ **Space Complexity:** O(K)

---

### **Java Code Example**

```java
import java.util.*;

public class LongestSubstringExactlyKDistinct {
    public static int longestSubstringExactK(String s, int k) {
        if (s.length() == 0 || k == 0) return 0;
        
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }
            
            if (freqMap.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println("Length of longest substring with exactly " + k +
                           " distinct characters: " + longestSubstringExactK(s, k)); // 7
    }
}
```

---

### **Explanation**

* **Pointers:**

  * `left` → start of the window
  * `right` → end of the window
* **Steps (Example s = "aabacbebebe", k = 3):**

```
Window starts expanding:
right=0: 'a', map={a:1} -> size<k -> skip
right=1: 'a', map={a:2} -> size<k -> skip
right=2: 'b', map={a:2,b:1} -> size<k -> skip
right=3: 'a', map={a:3,b:1} -> size<k -> skip
right=4: 'c', map={a:3,b:1,c:1} -> size==k -> maxLen=5
right=5: 'b', map={a:3,b:2,c:1} -> size==k -> maxLen=6
right=6: 'e', map={a:3,b:2,c:1,e:1} -> size>k -> shrink from left
    remove 'a' -> map={a:2,b:2,c:1,e:1} -> size>k
    remove 'a' -> map={a:1,b:2,c:1,e:1} -> size>k
    remove 'a' -> map={b:2,c:1,e:1} -> size==k -> left=3
right=6 window="cbebe" length=5, maxLen remains 6
...
Continue until right=10, maxLen=7 for "cbebebe"
```

---

**Key Idea:**

* Maintain a **sliding window** with **≤ K distinct characters**.
* Update **maxLen only when window has exactly K distinct characters**.
* **Shrink from left** when distinct characters exceed K.
