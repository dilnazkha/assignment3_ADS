# Assignment 3: Sorting and Searching Algorithm Analysis System
# Dilnaz Khazadiyaz BDA-2501

This project implements and compares three fundamental algorithms in Java:

1. **Selection Sort** as the basic sorting algorithm
2. **Merge Sort** as the advanced sorting algorithm
3. **Binary Search** as the searching algorithm

The purpose of this experiment is to analyze how different algorithms perform on arrays of different sizes and structures. The program measures execution time using `System.nanoTime()` and prints the results in a clear table format.

The project also demonstrates object-oriented programming through separate classes:

- `Sorter.java` handles sorting operations.
- `Searcher.java` handles searching operations.
- `Experiment.java` runs experiments and measures execution time.
- `Main.java` starts the program.

---

## B. Algorithm Descriptions

### 1. Selection Sort

Selection Sort is a basic sorting algorithm. It works by repeatedly finding the smallest element in the unsorted part of the array and moving it to the correct position.

Example logic:

- Find the smallest value in the array.
- Swap it with the first element.
- Then find the next smallest value.
- Continue until the whole array is sorted.

**Time Complexity:**

| Case | Complexity |
|---|---|
| Best Case | O(n²) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

Selection Sort is simple, but it becomes slow for large arrays because it uses nested loops.


### 2. Merge Sort

Merge Sort is an advanced sorting algorithm. It uses the divide-and-conquer approach. The array is divided into smaller parts, each part is sorted, and then the sorted parts are merged back together.

Example logic:

- Divide the array into two halves.
- Continue dividing until each part has one element.
- Merge the small sorted parts together.
- Continue merging until the full array is sorted.

**Time Complexity:**

| Case | Complexity |
|---|---|
| Best Case | O(n log n) |
| Average Case | O(n log n) |
| Worst Case | O(n log n) |

Merge Sort is usually faster than Selection Sort on large arrays because it does not compare every element with every other element.



### 3. Binary Search

Binary Search is an efficient searching algorithm. It works only on a sorted array. It checks the middle element and then removes half of the search area each time.

Example logic:

- Check the middle element.
- If the target is equal to the middle element, the search is complete.
- If the target is larger, search the right half.
- If the target is smaller, search the left half.

**Time Complexity:**

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(log n) |
| Worst Case | O(log n) |

Binary Search is very efficient because it reduces the search area by half after each comparison.

---

## C. Experimental Results

The program tests four array sizes:

- Small: 10 elements
- Medium: 100 elements
- Large: 1000 elements
- Extra large: 5000 elements

It also tests two input types:

- Random arrays
- Sorted arrays

Example output format:

| Size | Input Type | Selection Sort (ns) | Merge Sort (ns) | Binary Search (ns) |
|---:|---|---:|---:|---:|
| 10 | Random | Add your result | Add your result | Add your result |
| 10 | Sorted | Add your result | Add your result | Add your result |
| 100 | Random | Add your result | Add your result | Add your result |
| 100 | Sorted | Add your result | Add your result | Add your result |
| 1000 | Random | Add your result | Add your result | Add your result |
| 1000 | Sorted | Add your result | Add your result | Add your result |
| 5000 | Random | Add your result | Add your result | Add your result |
| 5000 | Sorted | Add your result | Add your result | Add your result |



---

## Analysis

Merge Sort performed faster than Selection Sort, especially for larger arrays. This is because Merge Sort has a time complexity of O(n log n), while Selection Sort has a time complexity of O(n²). When the array size increases, Selection Sort needs many more comparisons, so it becomes much slower.
As the input size increases, execution time also increases. The increase is much stronger for Selection Sort because its O(n²) complexity grows quickly. Merge Sort also takes more time for larger arrays, but its growth is slower and more efficient.
For Selection Sort, sorted data does not significantly improve performance because the algorithm still searches through the remaining part of the array to find the minimum element. For Merge Sort, sorted data also does not change the Big-O complexity because the array is still divided and merged. However, small practical differences may appear because of system behavior and memory usage.
The results generally match the expected Big-O complexity. Selection Sort becomes much slower as the input size grows, which matches O(n²). Merge Sort remains more efficient for large arrays, which matches O(n log n). Binary Search is very fast because it follows O(log n).
Binary Search is more efficient than Linear Search because it does not check every element one by one. Instead, it repeatedly divides the search area in half. This makes it much faster for large sorted arrays.
Binary Search requires a sorted array because it decides whether to search the left half or the right half based on the middle value. If the array is not sorted, the algorithm cannot correctly know which side may contain the target value.

---

## D. Screenshots
![Program Output](docs/screenshots/img.png)





## E. Reflection

This assignment helped me understand that algorithm efficiency is very important when the input size becomes larger. For small arrays, the difference between Selection Sort and Merge Sort may not look very large. However, for large arrays, Merge Sort becomes much faster because it uses a more efficient divide-and-conquer approach.
I also learned that theoretical Big-O complexity and practical execution time are connected, but actual results can still vary. The measured time depends on the computer, memory, background processes, and JVM behavior. One challenge during implementation was making sure that each algorithm was tested fairly. To solve this, I used copies of arrays so that Selection Sort and Merge Sort worked on the same original data.

