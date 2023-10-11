<H1> Java Algorithms and Challenges </H1>

Welcome to the Java Algorithms and Challenges repository! </br>
This repository showcases various algorithms and challenges written in Java. </br>
It's a go-to place for developers looking to sharpen their problem-solving skills and coding prowess.
</br>

<H3>LeetCode 75 list of challenges</H3>

[A great roadmap can be found here.](https://neetcode.io/roadmap)

- ArraysAndHashing
- ContainsDuplicate
- GroupAnagrams
- TwoSum
- ValidAnagram
- Top k frequent elements
- Valid (String) palindrome
- Two Sum II - Input array is sorted
  </br>
  </br>

<H3>Interesting</H3>

- MaximumSubarray
- PalindromeNumber
- RomanToInteger
- Fast Fourier Transform
- Remove element
- Remove duplicate from sorted array
  </br>
  </br>

<H3>Random Problems</H3>

- BigFibs _(This doesn't fail)_
- DuplicateCharacters
- Fibs _(This fails starting with the 93rd number)_
- FrequencyDistribution
- HorseRace
- KidsWithCandy
- MajorityElement
- PrimeFactorization
- ReversedArray
- TortoiseAndHare _(Floyd’s cycle)_
  </br>
  </br>

<H3>Sort & Search</H3>

- BinarySearch
- DualPivotQuickSort
- MergeSort
- QuickSort
  </br>
  </br>

<H1> HOW TO approach & solve an algorithm problem </H1>

### **Understanding & Clarification**

1. **What exactly is being asked?**

- Sometimes problems are not stated clearly. Ensure you understand the task at hand.

2. **Are there any constraints or limitations?**

- Time complexity? Space complexity? Are in-place modifications allowed or not?

3. **What should be done in the case of edge cases or ambiguities?**

- What happens with an empty array? What if **`k`** is zero or greater than the array size? What if there are duplicates
  or negative numbers?

4. **What is the expected output format?**

- Sometimes it's not just about the right answer but also how it should be returned. Array, string, integer, etc?

### **Data Exploration**

1. **What does the input data look like?**

- Is the array sorted? Are the elements integers, strings, or custom objects?

2. **What are the data ranges?**

- How big/small can the integers be? What is the max/min length for the array?

### **Algorithm & Strategy**

1. **What type of problem is it?**

- Sorting, searching, dynamic programming, backtracking, etc.

2. **Is recursion an option?**

- Sometimes recursion simplifies the problem. But can you afford the stack space?

3. **What data structures might help?**

- Would a hash table be useful for quick lookups? Would a stack or queue help in traversal?

### **Optimization & Efficiency**

1. **How efficient is your first approach?**

- Always good to have a solution first. Then think, can it be optimized?

2. **Are there any steps that can be parallelized or broken down further?**

- Given your interest in dev-ops, this might be particularly relevant.

3. **What's the trade-off?**

- Sometimes you trade time complexity for space, or vice versa. Is it warranted?

### **Testing**

1. **How will you validate your solution?**

- Through unit tests, manual validation, or some other way?

2. **What are the corner cases?**

- These can sometimes trip you up if you haven't considered them.

### **Discussion & Presentation**

1. **How will you articulate your solution to others?**

- Sometimes the discussion with the interviewer is as important as getting the right answer.
  </br>
  </br>

2. **Are there alternative approaches?**

- Always good to discuss or at least think about other possible solutions.
  </br>
  </br>

---

<H1>The Big-O cheat sheet</H1>

### **Constant Time: O(1)**

**Examples:** Array index access, hash table lookups </br>
**What it means:** No matter how large the input, the operation takes constant time.

### **Logarithmic Time: O(log n)**

**Examples:** Binary search, finding the largest item in a binary search tree </br>
**What it means:** The time taken increases logarithmically as the input size increases.

### **Linear Time: O(n)**

**Examples:** Loops iterating through elements in a single collection (array, list, etc.) </br>
**What it means:** Time complexity grows in direct proportion to the size of the input.

### **Linear Logarithmic Time: O(n log n)**

**Examples:** Merge sort, quick sort, built-in sorting algorithms (often) </br>
**What it means:** Slightly worse than linear but better than quadratic time. Common in algorithms that divide input
data in each step.

### **Quadratic Time: O(n^2)**

**Examples:** Nested loops, bubble sort, insertion sort, selection sort </br>
**What it means:** Time complexity grows with the square of the size of the input data. Often undesirable.

### **Cubic Time: O(n^3)**

**Examples:** Triple nested loops </br>
**What it means:** Even worse than quadratic time. You usually want to avoid cubic time complexity.

### **Exponential Time: O(2^n)**

**Examples:** Recursive calculations like the naive Fibonacci sequence </br>
**What it means:** Extremely slow. As data grows, the number of operations grows exponentially.

### **Factorial Time: O(n!)**

**Examples:** Permutation generation, the naive traveling salesman problem </br>
**What it means:** The slowest of the bunch. Time complexity grows faster than exponential growth.

Space Complexity: <br>
Constant Space: O(1) <br>
Linear Space: O(n)

  <br>

<H3>🛠 Tips and Tricks 🛠 </H3>

Always consider the worst-case scenario when evaluating Big-O unless otherwise specified.
Ignore constant factors and lower order terms, focus on the dominating term.
Look for nested loops (O(n^2), O(n^3), etc.), recursive calls, and how the algorithm divides its input data (O(log n),
O(n log n)).