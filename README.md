 Project Overview

This project was created to compare the performance of basic sorting, advanced sorting, and searching algorithms using Java.

The selected algorithms are:
Bubble Sort (Basic Sorting)
Quick Sort(Advanced Sorting)
Linear Search (Searching)

The purpose of this experiment is to measure execution time, compare algorithm efficiency, and understand how input size and data type affect performance.
Algorithm Descriptions

1. Bubble Sort
Bubble Sort repeatedly compares neighboring elements and swaps them if they are in the wrong order.
Time Complexity:
- Best Case: *O(n)*
- Average Case: *O(n²)*
- Worst Case: *O(n²)*
Advantages:
- Easy to understand
- Good for small arrays
Disadvantages:
- Slow for large datasets


2. Quick Sort
Quick Sort uses divide-and-conquer strategy. It selects a pivot element, partitions the array, then recursively sorts subarrays.
Time Complexity:
Best Case: *O(n log n)*
Average Case: *O(n log n)*
Worst Case: *O(n²)*
Advantages:
Very fast in practice
Efficient for large arrays
Disadvantages:
Worst case possible on sorted arrays depending on pivot choice

3. Linear Search
Linear Search checks elements one by one until the target value is found.
Time Complexity:
Best Case: O(1)
Worst Case: O(n)
Advantages:
Works on unsorted arrays
Very simple
Disadvantages:
Slow for large arrays
Experimental Results

Test Data
Arrays were tested with sizes:
Small = 10 elements
Medium = 100 elements
Large = 1000 elements

Input types:
Random arrays
Sorted arrays

Sample Results Table
| Size | Bubble Sort | Quick Sort | Linear Search |
|------|------------|------------|--------------|
| 10   | 8100  ns   | 12700 ns   | 4600 ns      |
| 100  | 300300 ns  | 42600 ns   | 3100 ns      |
| 1000 | 1829600 ns | 170200 ns  | 12100 ns     |

Analysis

Which sorting algorithm performed faster? Why?
Quick Sort performed faster than Bubble Sort, especially for medium and large arrays. This is because Quick Sort uses divide-and-conquer with average complexity *O(n log n), while Bubble Sort uses repeated comparisons with **O(n²)* complexity.

How does performance change with input size? As array size increases: Bubble Sort becomes much slower. Quick Sort remains efficient. Linear Search increases linearly

Large arrays clearly show the difference between efficient and inefficient algorithms.

How does sorted vs unsorted data affect performance? Bubble Sort works faster on sorted arrays if optimized. Quick Sort may become slower on sorted arrays if pivot is chosen badly. Linear Search depends on target position, not sorting

Do results match Big-O complexity? Yes, practical results match theoretical complexity:

Bubble Sort → O(n²)
Quick Sort → O(n log n)
Linear Search → O(n)

Which searching algorithm is more efficient? In this project, Linear Search was implemented. However, Binary Search would be more efficient (*O(log n)*), but it requires a sorted array. Why does Binary Search require a sorted array? Binary Search divides the array into halves and removes half of the search space each step. Without sorted order, it cannot know which half contains the target value.
