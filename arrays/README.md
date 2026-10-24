# 🔢 Arrays & Hashing

14 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [1. Two Sum](./0001-two-sum/README.md) | 🟢 Easy | [Solution.java](./0001-two-sum/Solution.java) | "Find a pair with property X" → think **HashMap of what I've seen so far**. |
| [66. Plus One](./0066-plus-one/README.md) | 🟢 Easy | [Solution.java](./0066-plus-one/Solution.java) | Simulating arithmetic on digit arrays → walk from the **least significant** end and track the carry. |
| [121. Best Time to Buy and Sell Stock](./0121-best-time-to-buy-and-sell-stock/README.md) | 🟢 Easy | [Solution.java](./0121-best-time-to-buy-and-sell-stock/Solution.java) | "Best pair where one comes before the other" → keep a **running min/max** of the prefix. |
| [169. Majority Element](./0169-majority-element/README.md) | 🟢 Easy | [Solution.java](./0169-majority-element/Solution.java) | "More than half" → **Boyer–Moore voting** gives O(1) space. |
| [215. Kth Largest Element in an Array](./0215-kth-largest-element-in-an-array/README.md) | 🟡 Medium | [Solution.java](./0215-kth-largest-element-in-an-array/Solution.java) | "k-th largest / top k" → **min-heap of size k**. |
| [1295. Find Numbers with Even Number of Digits](./1295-find-numbers-with-even-number-of-digits/README.md) | 🟢 Easy | [Solution.java](./1295-find-numbers-with-even-number-of-digits/Solution.java) | `num /= 10` strips a digit; `num % 10` reads the last digit. These two show up in every digit problem. |
| [1480. Running Sum of 1d Array](./1480-running-sum-of-1d-array/README.md) | 🟢 Easy | [Solution.java](./1480-running-sum-of-1d-array/Solution.java) | Prefix sums turn "sum of a range" questions into O(1) lookups later. This problem is the foundation. |
| [1672. Richest Customer Wealth](./1672-richest-customer-wealth/README.md) | 🟢 Easy | [Solution.java](./1672-richest-customer-wealth/Solution.java) | A 2D array is just an array of arrays: the outer loop picks the row, the inner loop walks it. |
| [1920. Build Array from Permutation](./1920-build-array-from-permutation/README.md) | 🟢 Easy | [Solution.java](./1920-build-array-from-permutation/Solution.java) | Using array values as indices is a common pattern in permutation problems. |
| [1929. Concatenation of Array](./1929-concatenation-of-array/README.md) | 🟢 Easy | [Solution.java](./1929-concatenation-of-array/Solution.java) | Index arithmetic (`i + n`) lets one loop fill multiple places at once. |
| [3483. Unique 3-Digit Even Numbers](./3483-unique-3-digit-even-numbers/README.md) | 🟢 Easy | [Solution.java](./3483-unique-3-digit-even-numbers/Solution.java) | When the answer space is **small and fixed**, enumerate answers and validate them instead of generating combinations. |
| [3550. Smallest Index With Digit Sum Equal to Index](./3550-smallest-index-with-digit-sum-equal-to-index/README.md) | 🟢 Easy | [Solution.java](./3550-smallest-index-with-digit-sum-equal-to-index/Solution.java) | "Smallest index such that…" → a left-to-right scan with an **early return**. |
| [3551. Minimum Swaps to Sort by Digit Sum](./3551-minimum-swaps-to-sort-by-digit-sum/README.md) | 🟡 Medium | [Solution.java](./3551-minimum-swaps-to-sort-by-digit-sum/Solution.java) | "Minimum swaps to sort" → **cycle decomposition**: `answer = n − cycles`. |
| [3668. Restore Finishing Order](./3668-restore-finishing-order/README.md) | 🟢 Easy | [Solution.java](./3668-restore-finishing-order/Solution.java) | "Keep the order of A, but only elements in B" → **filter A** with a fast lookup of B. |

[⬅️ Back to all solutions](../README.md)
