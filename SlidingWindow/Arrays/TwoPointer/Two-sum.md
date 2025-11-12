### **Problem**

Given a **sorted array** `arr` and a **target sum** `target`, find **two numbers** whose sum equals the target. Return their indices or values.

---

### **Approach: Two Pointers**

Since the array is **sorted**, we can use **two pointers**:

1. **Left pointer** `l` starting at index 0.
2. **Right pointer** `r` starting at the last index.

**Steps:**

1. Compute `sum = arr[l] + arr[r]`.
2. If `sum == target`, we found the pair.
3. If `sum < target`, increment `l` (we need a bigger number).
4. If `sum > target`, decrement `r` (we need a smaller number).
5. Repeat until `l < r`.

✅ This works in **O(n)** time and **O(1)** space.

---

### **Java Code Example**

```java
public class TwoSumSorted {
    public static int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == target) {
                return new int[]{left, right}; // return indices
            } else if (sum < target) {
                left++; // increase sum
            } else {
                right--; // decrease sum
            }
        }
        return new int[]{-1, -1}; // no pair found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8};
        int target = 10;
        int[] result = twoSum(arr, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
```

---

### **Explanation**

* Start with `left = 0` and `right = n-1`.
* The array is sorted, so:

  * If the sum is **too small**, move left forward → bigger numbers.
  * If the sum is **too large**, move right backward → smaller numbers.
* Repeat until pointers meet or pair is found.

**Example:**

```
arr = [1, 2, 3, 4, 6, 8], target = 10
left = 0 (1), right = 5 (8)
sum = 1 + 8 = 9 < 10 → move left to 1 (2)
sum = 2 + 8 = 10 → found pair (2, 8) at indices 1 and 5
```

**Time Complexity:** O(n)
**Space Complexity:** O(1)

---
