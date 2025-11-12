## **Quick Sort in Java**

```java
import java.util.Arrays;

public class QuickSort {
    
    // Quick Sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Step 1: Partition the array
            int pi = partition(arr, low, high);
            
            // Step 2: Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);  // Left part
            quickSort(arr, pi + 1, high); // Right part
        }
    }

    // Partition function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Step 1: Choose pivot (last element)
        int i = low - 1;       // Index of smaller element

        for (int j = low; j < high; j++) {
            // Step 2: If current element <= pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Step 3: Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
```

---

## **Step-by-Step Explanation**

### **Idea of Quick Sort**

* **Divide and conquer** algorithm.
* Steps:

  1. Pick a **pivot** element (commonly last element).
  2. **Partition** the array: elements ≤ pivot go to the left, elements > pivot go to the right.
  3. Recursively apply Quick Sort to left and right subarrays.

---

### **Step 1: Choose a Pivot**

```java
int pivot = arr[high]; // Last element
```

* Pivot is used to **divide array into two parts**.
* Other pivot strategies: first element, middle element, random element (to avoid worst case).

---

### **Step 2: Partition the Array**

```java
int i = low - 1;
for (int j = low; j < high; j++) {
    if (arr[j] <= pivot) {
        i++;
        swap(arr[i], arr[j]);
    }
}
swap(arr[i + 1], arr[high]); // Place pivot in correct position
```

* `i` tracks the **position for elements smaller than pivot**.
* Elements ≤ pivot are moved to the **left**, elements > pivot remain on **right**.
* After the loop, **pivot is placed in its final sorted position**.

---

### **Step 3: Recursion**

```java
quickSort(arr, low, pi - 1);
quickSort(arr, pi + 1, high);
```

* Recursively sort **left** and **right** partitions.
* Base case: `low >= high` → array/subarray has 0 or 1 element → already sorted.

---

## **Visual Example**

Array: `{10, 7, 8, 9, 1, 5}`

**Initial call:** `low=0, high=5`, pivot = 5

**Partitioning:**

* Compare each element with pivot 5:

  * 10 > 5 → stay
  * 7 > 5 → stay
  * 8 > 5 → stay
  * 9 > 5 → stay
  * 1 ≤ 5 → swap with arr[i+1] → array becomes `{1, 7, 8, 9, 10, 5}`
* Swap pivot 5 with arr[i+1] → `{1, 5, 8, 9, 10, 7}`

**Now pivot index = 1**

* Left part: `{1}` → already sorted
* Right part: `{8, 9, 10, 7}` → recursive call

Repeat partition recursively until array is fully sorted:

```
[1, 5, 7, 8, 9, 10]
```

---

## **Key Points**

1. **In-place sorting:** Space complexity O(log n) due to recursion stack.
2. **Not stable:** Equal elements may change relative order.
3. **Time Complexity:**

   * Worst: O(n²) → occurs if array is already sorted and pivot chosen poorly.
   * Average: O(n log n) → random pivot avoids worst case.
4. **Best Case:** O(n log n) → perfectly balanced partitions.
5. **Advantages:** Very fast in practice, widely used.
6. **Disadvantages:** Not stable, recursion stack may cause O(log n) extra space.

---

✅ **Summary:**

* Quick Sort is the **fastest general-purpose comparison sort**.
* **Pivot choice is crucial** for performance.
* Use **random pivot or median-of-three** to avoid worst-case O(n²).
