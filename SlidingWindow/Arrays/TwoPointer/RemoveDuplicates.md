### **Problem**

Given a **sorted array**, remove duplicates **in-place** so that each element appears **only once**.
Return the **length of unique elements**.
Move all duplicates to the **end of the array** (optional, as usually the array beyond the unique length is ignored).

---

### **Approach: Slow & Fast Pointers**

1. Use a **slow pointer** `slow` to track the **position to write the next unique element**.
2. Use a **fast pointer** `fast` to traverse the array.
3. Compare `arr[fast]` with `arr[slow]`.

   * If they are **different**, increment `slow` and write `arr[fast]` to `arr[slow]`.
   * If they are **same**, just move `fast` forward.

✅ This works in **O(n)** time and **O(1)** space.

---

### **Java Code Example**

```java
public class RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        
        int slow = 0; // points to last unique element
        
        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        
        return slow + 1; // length of unique elements
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(arr);
        
        System.out.println("Length of unique elements: " + length);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

### **Explanation**

* **Initial array:** `[1, 1, 2, 2, 3, 4, 4, 5]`
* **Pointers:**

  * `slow = 0` → last unique element
  * `fast = 1` → scanning next element

**Steps:**

1. Compare `arr[fast]` with `arr[slow]`.
2. If different → increment `slow` and copy `arr[fast]` to `arr[slow]`.
3. Repeat until `fast` reaches the end.

**Example Walkthrough:**

```
arr = [1,1,2,2,3,4,4,5]
slow = 0, fast = 1 -> arr[1]==arr[0] -> skip
fast = 2 -> arr[2]!=arr[0] -> slow=1, arr[1]=2
fast = 3 -> arr[3]==arr[1] -> skip
fast = 4 -> arr[4]!=arr[1] -> slow=2, arr[2]=3
fast = 5 -> arr[5]!=arr[2] -> slow=3, arr[3]=4
fast = 6 -> arr[6]==arr[3] -> skip
fast = 7 -> arr[7]!=arr[3] -> slow=4, arr[4]=5
```

* **Result:** Unique elements `[1, 2, 3, 4, 5]`
* **Length:** `5`

**Time Complexity:** O(n)
**Space Complexity:** O(1)
