### **Problem**

Given a string `s`, reverse its characters **in-place**.

**Example:**

```
s = "hello"
Output = "olleh"
```

---

### **Approach: Two Pointers (Left & Right)**

1. Convert the string to a **character array** (strings are immutable in many languages).
2. Use **two pointers**:

   * `left` → starts at index `0`
   * `right` → starts at index `s.length() - 1`
3. Swap `s[left]` and `s[right]`.
4. Move `left++` and `right--`.
5. Repeat until `left >= right`.
6. Convert the array back to a string (if needed).

✅ **Time Complexity:** O(n)
✅ **Space Complexity:** O(1) (in-place)

---

### **Java Code Example**

```java
public class ReverseString {
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            // swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s); // "olleh"
    }
}
```

---

### **Explanation**

* **Pointers:**
  `left = 0`, `right = s.length - 1`

* **Steps:**

```
s = ['h','e','l','l','o']
left=0, right=4 -> swap h & o -> ['o','e','l','l','h']
left=1, right=3 -> swap e & l -> ['o','l','l','e','h']
left=2, right=2 -> pointers meet -> stop
```

* The array is now reversed **in-place**.

---

**Key Idea:**

* Swapping elements from **both ends** and moving toward the **center** reverses the string efficiently.
* No extra array or string is required.

---
