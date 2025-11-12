### **Problem**

Given a **sorted string** `s`, remove **consecutive duplicate characters** so that each character appears **only once**.

**Example:**

```
s = "aaabcc"
Output = "abc"
```

---

### **Approach: Two Pointers (Read & Write)**

1. Convert the string into a **character array** because strings are immutable in Java.
2. Use **two pointers**:

   * `write` → points to the position where the next **unique character** should be written.
   * `read` → scans the string from left to right.
3. Compare `arr[read]` with the **last written character** (`arr[write-1]`):

   * If different → write `arr[read]` to `arr[write]`, increment `write`.
   * If same → skip (duplicate).
4. After the loop, the first `write` characters contain the **deduplicated string**.

✅ **Time Complexity:** O(n)
✅ **Space Complexity:** O(1) (in-place in char array)

---

### **Java Code Example**

```java
public class RemoveDuplicatesSortedString {
    public static String removeDuplicates(String s) {
        if (s.length() == 0) return s;
        
        char[] arr = s.toCharArray();
        int write = 1; // first character is always unique
        
        for (int read = 1; read < arr.length; read++) {
            if (arr[read] != arr[write - 1]) {
                arr[write] = arr[read];
                write++;
            }
        }
        
        return new String(arr, 0, write);
    }

    public static void main(String[] args) {
        String s = "aaabcc";
        System.out.println("After removing duplicates: " + removeDuplicates(s)); // "abc"
    }
}
```

---

### **Explanation**

* **Pointers:**

  * `write = 1` → where the next **unique character** goes
  * `read = 1` → scanning the array

* **Steps:**

```
s = "aaabcc"
arr = ['a','a','a','b','c','c']

read=1: arr[1]='a', arr[write-1]='a' -> duplicate -> skip
read=2: arr[2]='a', arr[write-1]='a' -> duplicate -> skip
read=3: arr[3]='b', arr[write-1]='a' -> unique -> arr[write]=b, write=2
read=4: arr[4]='c', arr[write-1]='b' -> unique -> arr[write]=c, write=3
read=5: arr[5]='c', arr[write-1]='c' -> duplicate -> skip
```

* Result: first `write=3` characters → `'a','b','c'` → `"abc"`

---

**Key Idea:**

* Use **one pointer to track the last unique character written**, and **another pointer to scan**.
* Only write when a **new unique character** is found.

---
