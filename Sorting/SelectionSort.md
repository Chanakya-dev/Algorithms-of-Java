## **Selection Sort in Java**

```java
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // Step 1: Assume first unsorted element is minimum

            // Step 2: Find the minimum element in the unsorted part
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update minIndex if smaller element found
                }
            }

            // Step 3: Swap the found minimum element with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
```

---

## **Step-by-Step Explanation**

### **Idea of Selection Sort**

* The array is divided into **sorted** and **unsorted** parts.
* Repeatedly **select the minimum element** from the unsorted part and **move it to the sorted part**.
* Unlike Bubble Sort, Selection Sort **reduces the number of swaps**, but still has O(n²) comparisons.

---

### **Step 1: Outer Loop (`i`)**

```java
for (int i = 0; i < arr.length - 1; i++) { ... }
```

* Keeps track of the **first unsorted element**.
* After each pass, the **smallest element in the unsorted part** is moved to index `i`.

---

### **Step 2: Find Minimum in Unsorted Part**

```java
int minIndex = i;
for (int j = i + 1; j < arr.length; j++) {
    if (arr[j] < arr[minIndex]) {
        minIndex = j;
    }
}
```

* Loop through the **unsorted part** (`i+1` to end).
* Track the **index of the minimum element** (`minIndex`).

---

### **Step 3: Swap Minimum with First Unsorted**

```java
int temp = arr[minIndex];
arr[minIndex] = arr[i];
arr[i] = temp;
```

* Swap the **smallest element** with the **first element of the unsorted part**.
* Moves the element to its **correct sorted position**.

---

## **Visual Example**

Array: `{64, 25, 12, 22, 11}`

---

### **Pass 1 (`i = 0`)**

* Unsorted part: `{64, 25, 12, 22, 11}`
* Minimum element = `11` at index `4`
* Swap `11` with `64` → `{11, 25, 12, 22, 64}`

✅ 11 is now in correct position.

---

### **Pass 2 (`i = 1`)**

* Unsorted part: `{25, 12, 22, 64}`
* Minimum element = `12` at index `2`
* Swap `12` with `25` → `{11, 12, 25, 22, 64}`

✅ 12 is in correct position.

---

### **Pass 3 (`i = 2`)**

* Unsorted part: `{25, 22, 64}`
* Minimum element = `22` at index `3`
* Swap `22` with `25` → `{11, 12, 22, 25, 64}`

✅ 22 is in correct position.

---

### **Pass 4 (`i = 3`)**

* Unsorted part: `{25, 64}`
* Minimum element = `25` at index `3`
* Swap `25` with itself → no change → `{11, 12, 22, 25, 64}`

✅ Already sorted now.

---

### **Final Sorted Array**

```
[11, 12, 22, 25, 64]
```

---

## **Key Points**

1. **In-place sorting:** Space complexity O(1)
2. **Not stable:** Relative order of equal elements may change
3. **Time Complexity:**

   * Worst / Average / Best: O(n²) (always does all comparisons)
4. **Good for:** Small arrays, when **few swaps** are needed
5. **Main advantage over Bubble Sort:** Fewer swaps (exactly `n-1` swaps)
