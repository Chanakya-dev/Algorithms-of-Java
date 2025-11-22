# **HASHING PROBLEMS: BASE → ADVANCED**

---

## **🔹 BASE LEVEL (Foundational Hashing)**

### **1. Frequency Counting**

**Pattern:** `HashMap<Element, Count>`
**Problems:**

1. Count occurrences of elements in an array
2. Majority element (> n/2 occurrences)
3. First non-repeating character in a string
4. Element appearing more than n/k times
5. Find the mode of an array (most frequent element)
6. Character count in a string
7. Count elements with even/odd occurrences
8. Frequency of words in a sentence
9. Find element with maximum frequency
10. Count distinct elements in an array

---

### **2. Existence / Set Checking**

**Pattern:** `HashSet`
**Problems:**

1. Detect duplicates in an array
2. Check if two arrays intersect
3. Missing numbers in 1..n
4. Check if array contains duplicates within k distance
5. Subset check: is A ⊆ B?
6. Find common elements in two arrays
7. Remove duplicates from array/string
8. Check if all characters in a string are unique
9. Count distinct elements in an array
10. Two arrays: check if they are disjoint

---

### **3. Two Sum / Pair Problems**

**Pattern:** `HashMap<element, index>`
**Problems:**

1. Two Sum (sum = target)
2. Pair with given difference
3. Count pairs with given sum
4. Pair with XOR = K
5. Check if a pair exists with sum divisible by k
6. Two numbers whose product = target
7. Check for zero-sum pairs in an array
8. Count pairs with absolute difference = k
9. Find all unique pairs summing to target
10. Find pairs with sum closest to target

---

## **🔹 INTERMEDIATE LEVEL (Hashing + Patterns)**

### **4. Subarray / Subsequence Problems**

**Pattern:** `Prefix sum + HashMap`
**Problems:**

1. Longest subarray with sum = 0
2. Subarray with sum divisible by k
3. Count subarrays with sum = k
4. Longest consecutive sequence
5. Longest subarray with equal number of 0s and 1s
6. Count subarrays with XOR = K
7. Longest arithmetic subarray
8. Subarray with sum closest to target
9. Count subarrays with sum less than k
10. Maximum length subarray with sum = target

---

### **5. Sliding Window + Hashing**

**Pattern:** `HashMap/HashSet + window`
**Problems:**

1. Longest substring without repeating characters
2. Longest substring with at most k distinct characters
3. Count distinct elements in every window of size k
4. Maximum sum subarray with distinct elements
5. Smallest window containing all distinct characters
6. Longest substring with exactly k distinct characters
7. Count subarrays with at most k distinct elements
8. Longest substring with no repeating vowels
9. Minimum window substring containing all chars of another string
10. Longest substring with unique characters (cyclic string)

---

### **6. Anagram / String Matching**

**Pattern:** `Frequency array/hashmap of char`
**Problems:**

1. Check if two strings are anagrams
2. Group anagrams from a list of strings
3. Find all anagram substrings in a string
4. Count anagrams of a pattern in a string
5. Longest substring forming an anagram of another string
6. Check palindrome permutations using character counts
7. Minimum swaps to make two strings anagrams
8. Check if one string is a scrambled anagram of another
9. Find largest anagram group
10. Count distinct anagram substrings

---

### **7. Modular / Remainder Hashing**

**Pattern:** `HashMap<prefixSum % k, count>`
**Problems:**

1. Subarray sum divisible by k
2. Count subarrays with sum divisible by k
3. Longest subarray sum divisible by k
4. Check if array can be divided into subarrays with sum divisible by k
5. Count pairs with sum divisible by k
6. Subarray sum equal to multiple of k
7. Count subarrays with remainder r
8. Maximum length subarray divisible by k
9. Subarray sums with equal modulo counts
10. Circular subarray sum divisible by k

---

## **🔹 ADVANCED LEVEL (Complex Hashing)**

### **8. Bitmask / XOR Hashing**

**Pattern:** `Integer bitmask to encode state`
**Problems:**

1. Palindrome permutation check
2. Count subarrays with XOR = K
3. Subset XOR = target
4. Count subsets with even/odd XOR
5. Maximum XOR of two numbers in array
6. Longest subarray with XOR = 0
7. Check if a string can be rearranged to palindrome using bitmask
8. Subarray XOR divisible by k
9. Count number of subarrays with XOR ≤ K
10. Find two numbers in array with maximum XOR

---

### **9. Sum / Combination Problems**

**Pattern:** `HashMap to store complements`
**Problems:**

1. 3Sum
2. 4Sum
3. Count pairs/triplets with sum = k
4. Two Sum variants (unique pairs)
5. 3Sum closest
6. Count quadruples with sum = k
7. Find if sum of two pairs = target
8. Count pairs with sum divisible by k
9. K-Sum problem using hashing
10. Maximum sum of pair with constraints

---

### **10. Rolling Hash / String Hashing**

**Pattern:** `Hash(substring) → O(1) compare`
**Problems:**

1. Rabin-Karp string matching
2. Detect duplicate substrings of length k
3. Longest common substring using hashing
4. Find repeated DNA sequences
5. Count distinct substrings
6. Check if one string is substring of another using hash
7. Longest palindrome substring using hash
8. Minimum window substring matching using hash
9. Check rotations of string using hash
10. Find anagrams using rolling hash

---

### **11. Coordinate Compression / Mapping**

**Pattern:** `Map large value → small index`
**Problems:**

1. Map array values to ranks for LIS
2. 2D coordinate mapping for grid problems
3. Count elements smaller on right/left
4. Compress large numbers for segment tree
5. Map 2D points to 1D hash
6. Maximum points in rectangle using compressed coordinates
7. Range query using compressed indices
8. Count smaller numbers before/after
9. Compress coordinates for Fenwick tree
10. Rank transform of array

---

### **✅ Notes for Interview Preparation**

* **Most asked base problems:** Two Sum, duplicates, majority element, first non-repeating character
* **Intermediate patterns:** Sliding window, subarray sum, anagrams, modular hashing
* **Advanced patterns:** XOR/bitmask, rolling hash, coordinate compression, K-Sum
* **Key tip:** Almost all hashing problems reduce to **“have I seen this before?”**

---
