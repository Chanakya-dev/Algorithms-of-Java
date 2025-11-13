## **1️⃣ What is Merge Sort?**

* Merge Sort is a **divide-and-conquer sorting algorithm**.
* It **recursively splits** the array into halves until each half has **one element**, then **merges them back** in sorted order.
* Works for **both ascending and descending sorting**.

---

## **2️⃣ How Merge Sort Works**

### Step 1: Divide

* Split the array into two halves.
* Keep dividing each half until you have subarrays of size 1 (base case).

### Step 2: Conquer (Merge)

* Merge two sorted subarrays into a single sorted array.
* Compare elements from each subarray and place the smaller (or larger for descending) element first.

---

### **Example: Ascending Sort**

Array: `[6, 3, 8, 5]`

**Step 1: Divide**

```
[6, 3, 8, 5] → [6, 3] and [8, 5]
[6, 3] → [6] and [3]
[8, 5] → [8] and [5]
```

**Step 2: Merge**

```
[6] and [3] → [3, 6]
[8] and [5] → [5, 8]
[3, 6] and [5, 8] → [3, 5, 6, 8]
```

Sorted array: `[3, 5, 6, 8]`

---

## **3️⃣ Code Example (Descending Order)**

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {2, 9, 4, 7, 6, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);        // sort left half
            mergeSort(arr, mid + 1, right);   // sort right half

            merge(arr, left, mid, right);     // merge halves
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        // Merge in descending order
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
```

✅ Output:

```
[9, 7, 6, 4, 3, 2]
```

---

## **4️⃣ Complexity Analysis**

| Aspect                    | Complexity                            |
| ------------------------- | ------------------------------------- |
| **Time (best/worst/avg)** | O(n log n)                            |
| **Space**                 | O(n) (extra arrays used during merge) |
| **Stable?**               | Yes (relative order maintained)       |
| **Method**                | Divide & Conquer                      |

---

## **5️⃣ Why Merge Sort is Efficient**

* Guarantees **O(n log n)** time even in worst case.
* Works well for **linked lists** too (less extra space needed).
* Stable sorting → good for objects with keys.

---
