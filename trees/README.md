# 🌳 Trees & BST

5 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [103. Binary Tree Zigzag Level Order Traversal](./0103-binary-tree-zigzag-level-order-traversal/README.md) | 🟡 Medium | [Solution.java](./0103-binary-tree-zigzag-level-order-traversal/Solution.java) | "Level by level" → BFS with **`size = queue.size()`** to process one level at a time. |
| [114. Flatten Binary Tree to Linked List](./0114-flatten-binary-tree-to-linked-list/README.md) | 🟡 Medium | [Solution.java](./0114-flatten-binary-tree-to-linked-list/Solution.java) | The **rightmost node of the left subtree** is the preorder/inorder predecessor. That's the key idea behind Morris traversal. |
| [129. Sum Root to Leaf Numbers](./0129-sum-root-to-leaf-numbers/README.md) | 🟡 Medium | [Solution.java](./0129-sum-root-to-leaf-numbers/Solution.java) | Path-based tree problems → **DFS carrying state down** (here, the number built so far). |
| [199. Binary Tree Right Side View](./0199-binary-tree-right-side-view/README.md) | 🟡 Medium | [Solution.java](./0199-binary-tree-right-side-view/Solution.java) | "First node seen at each depth" → DFS with **`depth == list.size()`**. Change the visiting order to choose which side you see. |
| [1569. Number of Ways to Reorder Array to Get Same BST](./1569-number-of-ways-to-reorder-array-to-get-same-bst/README.md) | 🔴 Hard | [Solution.java](./1569-number-of-ways-to-reorder-array-to-get-same-bst/Solution.java) | Counting orderings that keep two groups' internal order → **binomial coefficient C(L+R, L)**. Use Pascal's triangle to get binomials under a modulus without division. |

[⬅️ Back to all solutions](../README.md)
