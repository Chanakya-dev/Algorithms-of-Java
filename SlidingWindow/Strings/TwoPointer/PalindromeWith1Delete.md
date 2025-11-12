### **Problem**

Given a string `s`, determine if it **can become a palindrome** after deleting **at most one character**.

**Example:**

```
s = "abca"
Output: true  // Remove 'c' → "aba" is a palindrome
```

---

### **Approach: Two Pointers + Conditional Skip**

1. Use **two pointers**:

   * `left = 0`
   * `right = s.length() - 1`
2. While `left < right`:

   * If `s[left] == s[right]`, move both pointers: `left++`, `right--`.
   * If `s[left] != s[right]`, **we have a chance to skip one character**:

     * Check **skip left** → isPalindrome(s, left+1, right)
     * Check **skip right** → isPalindrome(s, left, right-1)
     * If either returns `true`, the string can become a palindrome.
3. If pointers meet without more than one mismatch → return `true`.

---

### **Java Code Example**

```java
public class ValidPalindromeOneDeletion {

    public static boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, false);
    }

    private static boolean helper(String s, int left, int right, boolean deleted) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (deleted) return false; // already deleted one character
                // Try skipping left or right
                return helper(s, left + 1, right, true) || helper(s, left, right - 1, true);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abca";
        String s2 = "racecar";
        String s3 = "abcdef";

        System.out.println(s1 + ": " + validPalindrome(s1)); // true
        System.out.println(s2 + ": " + validPalindrome(s2)); // true
        System.out.println(s3 + ": " + validPalindrome(s3)); // false
    }
}
```

---

### **Explanation**

* **Pointers:**
  `left` starts at 0, `right` starts at end.
* **Steps for "abca":**

```
s = "abca"
left=0, right=3 -> 'a'=='a' -> move pointers
left=1, right=2 -> 'b'!='c' -> can delete one
   skip left: check "ca" (b removed) -> not palindrome
   skip right: check "bc" (c removed) -> palindrome
=> return true
```

* **Key Idea:**

  * Use two pointers moving toward the center.
  * When mismatch occurs, allow **one conditional skip**.
  * Only **one deletion** is allowed.

---

### **Time Complexity**

* O(n) in most cases, worst-case O(n) recursion for one mismatch.
* Space complexity O(1) if iterative, O(n) if recursion is counted.

---
