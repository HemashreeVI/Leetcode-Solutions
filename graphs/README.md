# 🕸️ Graphs

2 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [200. Number of Islands](./0200-number-of-islands/README.md) | 🟡 Medium | [Solution.java](./0200-number-of-islands/Solution.java) | A grid is a graph with 4 edges per cell. "How many groups?" = **count connected components**: scan, flood-fill each new one. |
| [733. Flood Fill](./0733-flood-fill/README.md) | 🟢 Easy | [Solution.java](./0733-flood-fill/Solution.java) | The paint bucket: change one connected component as you explore it. **If the new colour equals the old one, return early.** |

[⬅️ Back to all solutions](../README.md)
