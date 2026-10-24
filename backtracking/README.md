# 🧩 Backtracking

4 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [17. Letter Combinations of a Phone Number](./0017-letter-combinations-of-a-phone-number/README.md) | 🟡 Medium | [Solution.java](./0017-letter-combinations-of-a-phone-number/Solution.java) | "Generate all combinations" → **backtracking template**: choose, recurse, undo. |
| [22. Generate Parentheses](./0022-generate-parentheses/README.md) | 🟡 Medium | [Solution.java](./0022-generate-parentheses/Solution.java) | Prune early: **only explore moves that can still lead to a valid answer**. |
| [39. Combination Sum](./0039-combination-sum/README.md) | 🟡 Medium | [Solution.java](./0039-combination-sum/Solution.java) | Recursing with `i` lets an element be **reused**; recursing with `i + 1` uses it **once**. Using a `start` index avoids permuted duplicates. |
| [46. Permutations](./0046-permutations/README.md) | 🟡 Medium | [Solution.java](./0046-permutations/Solution.java) | Permutations → **`used[]` array**; combinations → **`start` index**. |

[⬅️ Back to all solutions](../README.md)
