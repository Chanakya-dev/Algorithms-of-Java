
## **Insertion Sort**

```java
int[] arr = {12, 11, 54, 65, 76, 78, 90, 2};
for (int i = 1; i < arr.length; i++) {
    int k = arr[i];        // Step 1: Pick the element to insert
    int j = i - 1;         // Step 2: Start comparing with previous elements

    // Step 3: Shift all elements greater than 'k' to the right
    while (j >= 0 && arr[j] > k) {
        arr[j + 1] = arr[j];
        j--;
    }

    // Step 4: Insert 'k' at its correct position
    arr[j + 1] = k;
}
```

## **Step-by-Step Explanation**

1. **Start from the second element (`i = 1`)**

   * The first element (`arr[0]`) is considered **sorted**.
   * Example: `arr = {12, 11, 54, 65, 76, 78, 90, 2}` → `12` is sorted, `11` is next to insert.

2. **Pick the current element (`k = arr[i]`)**

   * `k` is the element we want to **insert** into the sorted part.
   * For `i = 1`, `k = 11`.

3. **Compare with the sorted part (elements to the left)**

   * Start from `j = i - 1` (previous element).
   * Move elements **greater than `k` one step to the right**.
   * `while(j >= 0 && arr[j] > k)` ensures we don’t go out of bounds and only shift larger elements.

4. **Insert `k` into its correct position**

   * After shifting, the correct position is `j + 1`.
   * Place `k` there.

---

### **Visual Example for `arr = {12, 11, 54, 65, 76, 78, 90, 2}`**

#### Iteration 1 (`i = 1`):

* `k = 11`, sorted part: `{12}`
* Compare `11 < 12` → shift `12` right → array becomes `{12, 12, 54, 65,...}`
* Insert `11` at index `0` → `{11, 12, 54, 65,...}`

#### Iteration 2 (`i = 2`):

* `k = 54`, sorted part: `{11, 12}`
* `54 > 12` → no shifting
* Insert `54` at index `2` → unchanged

#### Iteration 3 (`i = 3`):

* `k = 65`, sorted part: `{11, 12, 54}`
* `65 > 54` → no shifting
* Insert `65` at index `3` → unchanged

#### Iteration 4 (`i = 7`):

* `k = 2`, sorted part: `{11, 12, 54, 65, 76, 78, 90}`
* Compare with all → shift all elements right → array becomes `{11, 11, 12, 54,...}`
* Insert `2` at index `0` → final sorted array: `{2, 11, 12, 54, 65, 76, 78, 90}`

---

## **Key Points**

* **In-place sorting:** Doesn’t use extra arrays (space complexity O(1)).
* **Stable sort:** Maintains the relative order of equal elements.
* **Best case:** Already sorted → O(n)
* **Worst/Average case:** Reverse sorted → O(n²)
* **Good use case:** Small arrays or **nearly sorted arrays**.

---

### **Output of Your Code**

```
[2, 11, 12, 54, 65, 76, 78, 90]
```

---
