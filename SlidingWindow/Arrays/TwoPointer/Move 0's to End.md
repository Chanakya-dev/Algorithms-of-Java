### **Problem**

Given an array `arr`, **move all zeros to the end** while **maintaining the relative order** of non-zero elements.

**Constraint:** Do this **in-place**, using **two pointers**.

---

### **Approach: Two Pointers (Left & Right)**

1. **Left pointer** `left` → position to place the next non-zero element.
2. **Right pointer** `right` → scans the array from start to end.

**Steps:**

1. Iterate `right` from 0 to `arr.length-1`.
2. If `arr[right] != 0`:

   * Swap `arr[left]` and `arr[right]` (or just assign).
   * Increment `left`.
3. After the loop, all non-zeros are at the front, zeros naturally move to the end.

✅ Time Complexity: O(n)
✅ Space Complexity: O(1)

---

### **Java Code Example**

```java
public class MoveZeros {
    public static void moveZeros(int[] arr) {
        int left = 0; // position to place next non-zero element
        
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] != 0) {
                // swap or assign
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeros(arr);
        
        System.out.print("Array after moving zeros: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

**Output:**

```
Array after moving zeros: 1 3 12 0 0
```

---

### **Explanation**

* **Pointers:**

  * `left = 0` → where the next non-zero should go
  * `right` → scans array

**Steps:**

```
arr = [0, 1, 0, 3, 12]
right=0 -> arr[0]=0 -> skip
right=1 -> arr[1]=1 -> swap arr[1] & arr[0] -> [1,0,0,3,12], left=1
right=2 -> arr[2]=0 -> skip
right=3 -> arr[3]=3 -> swap arr[3] & arr[1] -> [1,3,0,0,12], left=2
right=4 -> arr[4]=12 -> swap arr[4] & arr[2] -> [1,3,12,0,0], left=3
```

---

### **Practice Problems Using the Same Technique**

1. **Segregate Even and Odd Numbers**

   * Move all even numbers to the front, odd numbers to the end, maintaining order.

2. **Partition Array by Sign**

   * Move all negative numbers to the front, positive numbers to the end, maintaining order.

3. **Move Specific Elements to End**

   * Given an element `x`, move all occurrences of `x` to the end while maintaining order.

4. **Remove Duplicates in Sorted Array (Slow & Fast Pointer)**

   * Already discussed.

5. **Sort Array of 0s, 1s, and 2s (Dutch National Flag Problem)**

   * Use pointer placement to move 0s, 1s, 2s to correct positions.
