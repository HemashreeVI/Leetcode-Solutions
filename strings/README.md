# 🔤 Strings

6 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [13. Roman to Integer](./0013-roman-to-integer/README.md) | 🟢 Easy | [Solution.java](./0013-roman-to-integer/Solution.java) | Look one step ahead: a rule that depends on the **next element** can often be handled in a single pass. |
| [14. Longest Common Prefix](./0014-longest-common-prefix/README.md) | 🟢 Easy | [Solution.java](./0014-longest-common-prefix/Solution.java) | Start with the **largest possible answer** and shrink it until it's valid. |
| [28. Find the Index of the First Occurrence in a String](./0028-find-the-index-of-the-first-occurrence-in-a-string/README.md) | 🟢 Easy | [Solution.java](./0028-find-the-index-of-the-first-occurrence-in-a-string/Solution.java) | Substring search = **sliding window + compare**. Learn KMP once you're comfortable. |
| [58. Length of Last Word](./0058-length-of-last-word/README.md) | 🟢 Easy | [Solution.java](./0058-length-of-last-word/Solution.java) | If the answer lives at the end, **scan backwards** instead of splitting the whole string. |
| [3498. Reverse Degree of a String](./3498-reverse-degree-of-a-string/README.md) | 🟢 Easy | [Solution.java](./3498-reverse-degree-of-a-string/Solution.java) | `c - 'a'` converts a letter to a number: the most common character trick in Java. |
| [3675. Minimum Operations to Transform String](./3675-minimum-operations-to-transform-string/README.md) | 🟡 Medium | [Solution.java](./3675-minimum-operations-to-transform-string/Solution.java) | When operations **merge** groups, find the single element that takes the longest. Everything else rides along. |

[⬅️ Back to all solutions](../README.md)
