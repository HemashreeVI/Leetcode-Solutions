# 👉👈 Two Pointers

5 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [26. Remove Duplicates from Sorted Array](./0026-remove-duplicates-from-sorted-array/README.md) | 🟢 Easy | [Solution.java](./0026-remove-duplicates-from-sorted-array/Solution.java) | In-place filtering → **slow write pointer + fast read pointer**. |
| [27. Remove Element](./0027-remove-element/README.md) | 🟢 Easy | [Solution.java](./0027-remove-element/Solution.java) | Same pattern as #26: **read pointer scans, write pointer keeps**. |
| [42. Trapping Rain Water](./0042-trapping-rain-water/README.md) | 🔴 Hard | [Solution.java](./0042-trapping-rain-water/Solution.java) | When an answer depends on `min(leftSide, rightSide)`, **two pointers from both ends** let you resolve the smaller side first. |
| [88. Merge Sorted Array](./0088-merge-sorted-array/README.md) | 🟢 Easy | [Solution.java](./0088-merge-sorted-array/Solution.java) | In-place merge with spare room at the end → **fill from the back**. |
| [977. Squares of a Sorted Array](./0977-squares-of-a-sorted-array/README.md) | 🟢 Easy | [Solution.java](./0977-squares-of-a-sorted-array/Solution.java) | Extremes at both ends → **two pointers from the outside in**, filling the answer from the back. |

[⬅️ Back to all solutions](../README.md)
