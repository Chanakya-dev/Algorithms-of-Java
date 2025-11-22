## **1️⃣ What is Hashing?**

* **Definition:** Hashing is a technique to map data (keys) to a fixed-size value (hash code) using a **hash function**.
* **Purpose:** Allows **O(1) average time complexity** for insertion, deletion, and search.

**Key Components:**

1. **Hash Function:** Converts a key into an integer index.
2. **Hash Table:** Array-like data structure where elements are stored based on hash values.
3. **Collision Handling:** Two keys may hash to the same index. Handled using:

   * **Chaining:** Linked list at each bucket.
   * **Open addressing:** Linear probing, quadratic probing, double hashing.

**Examples of hashable data:**

* Integers, strings, tuples, or custom objects with defined `hashCode()` method in Java.

---

## **2️⃣ Hashing Data Structures**

| Structure                   | Purpose               | Notes                                         |
| --------------------------- | --------------------- | --------------------------------------------- |
| **HashMap / Dictionary**    | Key → Value mapping   | O(1) average insertion, search, deletion      |
| **HashSet / Set**           | Store unique elements | Only keys matter; check existence efficiently |
| **MultiMap / HashMultiset** | Key → Multiple Values | Useful for grouping or frequency counting     |

---

## **3️⃣ Basic Hashing Operations**

1. **Insert:** Add key/value → O(1) average
2. **Search:** Check if key exists → O(1) average
3. **Delete:** Remove key/value → O(1) average
4. **Update:** Modify value of existing key → O(1) average

**Notes:** Worst-case can degrade to O(n) if too many collisions, but rare with a good hash function.

---

## **4️⃣ Common Hashing Patterns**

### **A. Frequency Counting**

* **Problem type:** Count elements or characters.
* **Data structure:** `HashMap<Element, Count>`
* **Examples:**

  * Count occurrences of numbers in an array.
  * First non-repeating character in a string.
  * Majority element (`> n/2`).

**Tip:** Always consider default value 0 for new keys.

---

### **B. Existence Checking**

* **Problem type:** Check if an element exists efficiently.
* **Data structure:** `HashSet`
* **Examples:**

  * Detect duplicates in an array.
  * Check if arrays intersect.
  * Missing numbers in 1..n.

**Tip:** HashSet is faster than sorting for existence queries.

---

### **C. Two Sum / Pair Problems**

* **Problem type:** Find pairs with a specific sum or difference.
* **Data structure:** `HashMap` to store complements or seen values
* **Examples:**

  * Two Sum problem (`nums[i] + nums[j] = target`)
  * Count pairs with XOR = K

**Tip:** HashMap reduces O(n^2) brute-force → O(n).

---

### **D. Subarray / Subsequence Problems**

* **Problem type:** Find subarrays with specific properties using prefix sums.
* **Data structure:** `HashMap<PrefixSum, Index>`
* **Examples:**

  * Longest subarray with sum = 0
  * Subarray sum divisible by k
  * Longest consecutive elements

**Tip:** Think in terms of “have I seen this sum before?”

---

### **E. Sliding Window + Hashing**

* **Problem type:** Find substring/subarray properties in linear time.
* **Data structure:** `HashMap<Element, Count>`
* **Examples:**

  * Longest substring without repeating characters
  * Longest substring with at most k distinct characters
  * Count distinct elements in every window of size k

**Tip:** Maintain a window and expand/shrink using hash map counts.

---

### **F. Anagram / String Matching**

* **Problem type:** Compare character frequencies instead of strings.
* **Data structure:** `HashMap<char, count>` or array of size 26 for lowercase letters
* **Examples:**

  * Check if two strings are anagrams
  * Find all anagram substrings
  * Group anagrams

**Tip:** Can use **sorted string as key** or **tuple of counts** for hashing.

---

### **G. Modular / Remainder Hashing**

* **Problem type:** Detect patterns using modulo properties.
* **Data structure:** `HashMap<remainder, count>`
* **Examples:**

  * Subarray sum divisible by k
  * Count subarrays with remainder = r

**Tip:** Negative numbers need adjustment: `(prefixSum % k + k) % k`.

---

### **H. Bitmask / XOR Hashing**

* **Problem type:** Encode states as integers using bits.
* **Data structure:** `HashMap<int, count>`
* **Examples:**

  * Palindrome permutation checks
  * Subarrays with XOR = K
  * Counting subsets with XOR properties

**Tip:** Bitmasking reduces memory usage and simplifies subset problems.

---

### **I. Rolling Hash / String Hashing**

* **Problem type:** Efficient substring comparison.
* **Data structure:** Integer hash of substring
* **Examples:**

  * Rabin-Karp string search
  * Detect duplicate substrings
  * Longest common substring using hashing

**Tip:** Hashing substrings → O(1) comparison instead of O(n).

---

### **J. Coordinate Compression / Mapping**

* **Problem type:** Map large numbers → smaller indices.
* **Data structure:** `HashMap<Value, Rank>`
* **Examples:**

  * Convert array to ranks for LIS or Fenwick tree
  * Mapping 2D coordinates `(x,y)` for grid problems

**Tip:** Useful for problems with very large ranges or sparse data.

---

## **5️⃣ Edge Cases in Hashing**

1. Empty array or string
2. Negative numbers in prefix sum or modulo operations
3. Duplicate elements
4. Very large numbers → possible hash collisions
5. Single element arrays

---

## **6️⃣ Common Time Complexity**

| Operation                | Average | Worst-case |
| ------------------------ | ------- | ---------- |
| Insert / Update / Delete | O(1)    | O(n)       |
| Search                   | O(1)    | O(n)       |
| Iterate all elements     | O(n)    | O(n)       |

**Tip:** In interviews, assume O(1) for average-case unless told otherwise.

---

## **7️⃣ Tips & Tricks for Hashing Problems**

1. **“Seen before?” pattern:** Many problems reduce to checking if something exists in hash map.
2. **Prefix sum mapping:** For subarray sum problems, always store sum → index.
3. **Sliding window + hash:** Track counts inside a moving window for substrings/subarrays.
4. **Bitmasking:** Encode states to reduce memory usage (palindromes, subsets).
5. **Rabin-Karp / rolling hash:** For string comparison → O(1) substring comparison.
6. **Frequency as key:** For anagrams → frequency array tuple → hash map.

---
