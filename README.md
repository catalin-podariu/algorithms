
<H1> Java Algorithms and Challenges </H1>

Welcome to my version of the [LeetCode 75](https://leetcode.com/studyplan/leetcode-75) algorithms list.</br>
_(still work in progress..)_

There are other algorithms that I found interesting, in other places than the LeetCode. 
Those are in a different package.
</br>
This repository showcases various algorithms and challenges written in Java. </br>
It can also be a go-to place for other developers looking to sharpen their problem-solving 
skills and coding know-how.
</br>

<H3>LeetCode 75</H3> 

[A great roadmap for this can be found here](https://neetcode.io/roadmap)

<H3>Arrays and Hashing</H3>

- ✅ Contains duplicate
- ✅ Group anagrams
- ✅ Two sum
- ✅ Valid anagram
- ✅ Top k frequent elements
- ✅ Valid (String) palindrome
- ✅ Two Sum II _(input array is sorted)_

<H3>Linked Lists</H3>

- ✅ Linked list cycle
- ✅ Reverse Linked List
- ✅ Merge two sorted lists
- ✅ Add two numbers
- Commons:
  - ListUtils
    - createListWithLoop
    - createListOf
    - mergeSort
    - getMiddle
    - merge
    - hasLoop
  - Node _(with visual toString)_

<H3>Interesting</H3>

- ✅ Maximum subarray
- ✅ Palindrome number
- ✅ Roman to integer
- ⏳Fast fourier transform
- ✅ Remove element
- ✅ Remove duplicates from sorted array

<H3>Random Problems</H3>

- Big Fibs _(this doesn't fail)_
- ✅ First non-repeating character
- ✅ Fibs _(this fails starting with the 93rd number)_
- ✅ Frequency distribution
- ✅ Horse race
- ⏳ Kids with candy
- ✅ Majority element
- ✅ Prime factorization
- ✅ Reversed array
- ✅ LinkedList cycle

<H3>Sort & Search</H3>

- ⏳ Binary search
- ⏳ Dual-pivot quick sort
- ✅ Merge sort array
- ✅ Quick sort


_(each of these has, in the code, the context, examples and expected output)_

---

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
   - Sometimes it's not just about the right answer but also how it should be returned.

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

2. **What's the trade-off?**
   - Sometimes you trade time complexity for space, or vice versa. Is it warranted?

### **Testing**

1. **How will you validate your solution?**
   - Through unit tests, manual validation, or some other way?

2. **What are the corner cases?**
   - These can sometimes trip you up, if you haven't considered them.

### **Discussion & Presentation**

1. **How will you articulate your solution to others?**
   - Sometimes the discussion with the interviewer is as important as getting the right answer.

2. **Are there alternative approaches?**
   - Always good to discuss or at least think about other possible solutions.

---

<H1>Tips and tricks</H1>

Here's a plan you can follow to give you the best shot at climbing over that obstacle, even if it's a new and unfamiliar challenge.
</br>
Catching the quirks and nuances in a coding challenge right off the bat can often be the difference between a smooth implementation and getting bogged down. </br>

1. **Assume Nothing, Question Everything** </br>
   Even if the problem seems familiar, read every single word of the problem statement twice, as if you're a detective looking for clues. Quirks often lurk in the specifics.
2. **Look for "Loaded" Words** </br>
   Words like "sorted," "distinct," "unique," or "uniformly" often signal a quirk or a key detail about the data set you'll be working with.
3. **Check Constraints** </br>
   Extremely large or small input sizes can be a clue about the expected time complexity. A large upper limit may mean that your solution needs to be highly optimized.
4. **Examples Aren't Just Examples** </br>
   Test cases often hold hidden clues. Look at the edge cases in the example: are there any patterns or inconsistencies that could indicate a quirk?
5. **Read Between the Lines** </br>
   Sometimes, what's not said is as important as what's said. For example, if the prompt is vague about what to return for multiple correct answers, that’s something to note and clarify.
6. **Question the 'Given'** </br>
   If you're given certain information, there's usually a reason for it. Ask yourself why you have that piece of information and how it could be useful.
7. **Engage the Senses** </br>
   Visualize the problem or even draw it out. Sometimes seeing the problem visually can highlight patterns or quirks that aren't obvious when read.
8. **Check for Trick Questions** </br>
   Sometimes a problem seems harder than it actually is, or the naive solution is actually the correct one. Don't overcomplicate things.
9. **Human Check** </br>
   Think about the problem from a real-world perspective or how you would solve it manually without code. Sometimes real-world logic can shed light on programmatic quirks.
10. **Boomerang Technique** </br>
    Skim the problem, then walk away for a few minutes and let it simmer in your subconscious. Sometimes insights come when you’re not directly focusing on the problem.
11. **Trust Your Gut** </br>
    If something feels off or too easy, it probably is. Your instincts have been honed by your experience, so don't ignore them.
    

Having a robust mental toolkit like this can help you detect quirks and hidden details much more rapidly, allowing you to strategize more effectively.