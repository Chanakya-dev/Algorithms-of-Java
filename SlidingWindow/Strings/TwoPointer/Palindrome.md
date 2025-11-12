### **Problem**

Given a string `s`, determine if it **reads the same backward and forward**.

**Example:**

```
s = "racecar"
Output = true
```

---

### **Approach: Two Pointers (Left & Right)**

1. Use **two pointers**:

   * `left` → starts at index 0
   * `right` → starts at index `s.length() - 1`
2. Compare `s[left]` and `s[right]`.

   * If they are **not equal**, return `false` → string is **not a palindrome**.
   * If they are equal, move `left++` and `right--`.
3. Repeat until `left >= right`.
4. If all pairs match → return `true`.

✅ **Time Complexity:** O(n)
✅ **Space Complexity:** O(1)

---

### **Java Code Example**

```java
public class PalindromeString {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // mismatch found
            }
            left++;
            right--;
        }
        
        return true; // all matched
    }

    public static void main(String[] args) {
        String s1 = "racecar";
        String s2 = "hello";
        
        System.out.println(s1 + " is palindrome? " + isPalindrome(s1)); // true
        System.out.println(s2 + " is palindrome? " + isPalindrome(s2)); // false
    }
}
```

---

### **Explanation**

* **Pointers:**
  `left = 0`, `right = s.length - 1`

* **Steps (Example s = "racecar"):**

```
left=0, right=6 -> r==r -> move pointers
left=1, right=5 -> a==a -> move pointers
left=2, right=4 -> c==c -> move pointers
left=3, right=3 -> pointers meet -> stop
All matched -> palindrome
```

* **Example s = "hello":**

```
left=0, right=4 -> h!=o -> return false
```

✅ Efficient: linear time, constant space.

---

**Key Idea:**

* Compare characters from **both ends moving toward the center**.
* Any mismatch immediately tells the string is **not a palindrome**.
