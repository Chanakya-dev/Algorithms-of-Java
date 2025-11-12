# **1. Linear Search**

### **Concept**

* Check each element **one by one** until the target is found.
* Works for **unsorted arrays**.
* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

### **Java Code**

```java
import java.util.Arrays;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i; // return index
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;
        int index = linearSearch(arr, target);
        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found");
    }
}
```

**✅ Explanation:**

* Iterate through array from start to end.
* Return **index** if target found, else -1.
* Simple, works for **any array**, sorted or unsorted.

---

# **2. Binary Search**

### **Concept**

* Works **only on sorted arrays**.

* Divide and conquer:

  1. Find the middle element.
  2. If middle == target → found
  3. If middle > target → search **left half**
  4. If middle < target → search **right half**

* **Time Complexity:** O(log n)

* **Space Complexity:** O(1) iterative, O(log n) recursive

### **Java Code (Iterative)**

```java
import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 40;
        int index = binarySearch(arr, target);
        System.out.println("Element found at index: " + index);
    }
}
```

---

### **Java Code (Recursive)**

```java
public class BinarySearchRecursive {
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return binarySearch(arr, mid + 1, right, target);
        else return binarySearch(arr, left, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int index = binarySearch(arr, 0, arr.length - 1, target);
        System.out.println("Element found at index: " + index);
    }
}
```

**✅ Key Points:**

* Works **only on sorted arrays**.
* Much faster than linear search for large arrays.
* Iterative version is **space efficient**, recursive version uses stack memory.

---

# **3. Advanced Searching Techniques**

### **A. Jump Search**

* Works on **sorted arrays**.
* Jump ahead by √n steps and do **linear search** in the block.
* Time Complexity: O(√n)

### **B. Exponential Search**

* Find **range** first (powers of 2), then binary search in that range.
* Time Complexity: O(log n)

### **C. Ternary Search**

* Divide array into **3 parts** instead of 2 (binary search).
* Slightly less practical but good for **theoretical comparisons**.

---

# **4. Searching in 2D Arrays**

### **Row-wise and Column-wise Sorted Array**

* Use **staircase search**:

  * Start at **top-right** corner:

    * If current == target → found
    * If current > target → move left
    * If current < target → move down
* Time Complexity: O(n + m) for n × m matrix

### **Java Code**

```java
public class StaircaseSearch {
    public static boolean search2D(int[][] mat, int target) {
        int row = 0;
        int col = mat[0].length - 1;

        while (row < mat.length && col >= 0) {
            if (mat[row][col] == target) return true;
            else if (mat[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        int target = 29;
        System.out.println("Element found? " + search2D(mat, target));
    }
}
```

---

## **Summary Table: Searching Algorithms**

| Algorithm          | Works on            | Time Complexity | Space         | Notes                        |
| ------------------ | ------------------- | --------------- | ------------- | ---------------------------- |
| Linear Search      | Any array           | O(n)            | O(1)          | Simple, unsorted array       |
| Binary Search      | Sorted array        | O(log n)        | O(1)/O(log n) | Very fast, divide & conquer  |
| Jump Search        | Sorted array        | O(√n)           | O(1)          | Block jumping                |
| Exponential Search | Sorted array        | O(log n)        | O(1)          | Good for unbounded arrays    |
| Ternary Search     | Sorted array        | O(log₃ n)       | O(1)/O(log n) | Divide into 3 parts          |
| Staircase Search   | 2D row & col sorted | O(n + m)        | O(1)          | Optimal for 2D sorted arrays |
