## **Bubble Sort in Java**

```java
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
```

---

## **Step-by-Step Explanation**

### **Idea of Bubble Sort**

* Repeatedly **compare adjacent elements** and **swap them** if they are in the wrong order.
* “**Bubbles**” the largest element to the end of the array in each pass.
* Continue until the array is sorted.

---

### **Step 1: Outer Loop (`i`)**

```java
for (int i = 0; i < arr.length - 1; i++) { ... }
```

* Runs `n-1` times (where `n` is array length).
* After each pass, the **largest unsorted element** is moved to its correct position at the end.

---

### **Step 2: Inner Loop (`j`)**

```java
for (int j = 0; j < arr.length - i - 1; j++) { ... }
```

* Compares `arr[j]` with `arr[j + 1]`.
* `arr.length - i - 1` ensures we **ignore already sorted elements** at the end.

---

### **Step 3: Swap if needed**

```java
if (arr[j] > arr[j + 1]) {
    int temp = arr[j];
    arr[j] = arr[j + 1];
    arr[j + 1] = temp;
}
```

* If current element is **greater than next**, swap them.
* Otherwise, leave them as is.

---

## **Visual Example**

Array: `{64, 34, 25, 12, 22, 11, 90}`

---

### **Pass 1 (`i = 0`)**

* Compare 64 and 34 → swap → `{34, 64, 25, 12, 22, 11, 90}`
* Compare 64 and 25 → swap → `{34, 25, 64, 12, 22, 11, 90}`
* Compare 64 and 12 → swap → `{34, 25, 12, 64, 22, 11, 90}`
* Compare 64 and 22 → swap → `{34, 25, 12, 22, 64, 11, 90}`
* Compare 64 and 11 → swap → `{34, 25, 12, 22, 11, 64, 90}`
* Compare 64 and 90 → no swap → `{34, 25, 12, 22, 11, 64, 90}`

✅ **Largest element (90) is now at the end.**

---

### **Pass 2 (`i = 1`)**

* Compare 34 and 25 → swap → `{25, 34, 12, 22, 11, 64, 90}`
* Compare 34 and 12 → swap → `{25, 12, 34, 22, 11, 64, 90}`
* Compare 34 and 22 → swap → `{25, 12, 22, 34, 11, 64, 90}`
* Compare 34 and 11 → swap → `{25, 12, 22, 11, 34, 64, 90}`
* Compare 34 and 64 → no swap

✅ **Second largest element (64) is now in correct position.**

---

### **Pass 3 (`i = 2`)**

* Compare 25 and 12 → swap → `{12, 25, 22, 11, 34, 64, 90}`
* Compare 25 and 22 → swap → `{12, 22, 25, 11, 34, 64, 90}`
* Compare 25 and 11 → swap → `{12, 22, 11, 25, 34, 64, 90}`

✅ Now 25 is in correct position.

---

* Continue until the array is fully sorted:

```
[11, 12, 22, 25, 34, 64, 90]
```

---

## **Key Points**

1. **In-place sorting:** Space complexity O(1)
2. **Stable sort:** Maintains relative order of equal elements
3. **Time Complexity:**

   * Worst / Average: O(n²)
   * Best (already sorted): O(n) if optimized with a swapped flag
4. **Good for:** Small arrays, teaching purposes

---

### **Optimized Version (Stops if Already Sorted)**

```java
boolean swapped;
for (int i = 0; i < arr.length - 1; i++) {
    swapped = false;
    for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            swapped = true;
        }
    }
    if (!swapped) break; // stop if no swaps in a pass
}
```

* **Best case O(n)** for already sorted arrays.
