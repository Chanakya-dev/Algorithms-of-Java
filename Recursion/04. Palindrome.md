## **Check if a String is a Palindrome Recursively**

### **Problem**

A **palindrome** is a string that reads the same forwards and backwards.

* Example: `"racecar"` → true
* Example: `"hello"` → false

We want to check this **recursively**.

---

### **Key Concepts**

1. **Two-pointer logic** – Compare the first and last characters of the string.
2. **Base Case** – Stop recursion when:

   * The string is empty or has **one character** → palindrome by default.
   * Mismatch found → not a palindrome.
3. **Recursive Case** – Check the substring **excluding the first and last characters**.

---

### **Mathematical / Conceptual Idea**

Let `isPalindrome(s)` check if string `s` is a palindrome.

```
isPalindrome("racecar") = (r == r) && isPalindrome("aceca")
isPalindrome("aceca")   = (a == a) && isPalindrome("cec")
isPalindrome("cec")     = (c == c) && isPalindrome("e")
isPalindrome("e")       = true  // Base case
```

---

### **Step-by-Step Example: `"madam"`**

1. `isPalindrome("madam")` → check `'m' == 'm'` → yes → recurse `"ada"`
2. `isPalindrome("ada")` → check `'a' == 'a'` → yes → recurse `"d"`
3. `isPalindrome("d")` → base case → true

✅ Palindrome confirmed.

---

### **Code Example (Java)**

```java
public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        return isPalindromeHelper(str, 0, str.length() - 1);
    }

    private static boolean isPalindromeHelper(String str, int left, int right) {
        // Base case
        if (left >= right) return true;

        // If characters don't match
        if (str.charAt(left) != str.charAt(right)) return false;

        // Recursive case
        return isPalindromeHelper(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String s1 = "racecar";
        String s2 = "hello";

        System.out.println(s1 + " → " + isPalindrome(s1)); // true
        System.out.println(s2 + " → " + isPalindrome(s2)); // false
    }
}
```

---

### **Key Points**

1. Uses **two-pointer logic** but implemented recursively.
2. Base case ensures recursion **stops when all characters are checked**.
3. Recursive case **reduces problem size** by removing first and last characters.
4. Time Complexity: O(n)
5. Space Complexity: O(n) due to recursion stack

---
