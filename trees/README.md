# 🌳 Trees & BST

9 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [98. Validate Binary Search Tree](./0098-validate-binary-search-tree/README.md) | 🟡 Medium | [Solution.java](./0098-validate-binary-search-tree/Solution.java) | BST rules cover **whole subtrees**, not just children → carry a **(low, high) window** down and tighten it each step. |
| [103. Binary Tree Zigzag Level Order Traversal](./0103-binary-tree-zigzag-level-order-traversal/README.md) | 🟡 Medium | [Solution.java](./0103-binary-tree-zigzag-level-order-traversal/Solution.java) | "Level by level" → BFS with **`size = queue.size()`** to process one level at a time. |
| [114. Flatten Binary Tree to Linked List](./0114-flatten-binary-tree-to-linked-list/README.md) | 🟡 Medium | [Solution.java](./0114-flatten-binary-tree-to-linked-list/Solution.java) | The **rightmost node of the left subtree** is the preorder/inorder predecessor. That's the key idea behind Morris traversal. |
| [129. Sum Root to Leaf Numbers](./0129-sum-root-to-leaf-numbers/README.md) | 🟡 Medium | [Solution.java](./0129-sum-root-to-leaf-numbers/Solution.java) | Path-based tree problems → **DFS carrying state down** (here, the number built so far). |
| [199. Binary Tree Right Side View](./0199-binary-tree-right-side-view/README.md) | 🟡 Medium | [Solution.java](./0199-binary-tree-right-side-view/Solution.java) | "First node seen at each depth" → DFS with **`depth == list.size()`**. Change the visiting order to choose which side you see. |
| [230. Kth Smallest Element in a BST](./0230-kth-smallest-element-in-a-bst/README.md) | 🟡 Medium | [Solution.java](./0230-kth-smallest-element-in-a-bst/Solution.java) | "Sorted order" + BST → **inorder traversal**; do it iteratively with a stack to **stop at the k-th node**. |
| [450. Delete Node in a BST](./0450-delete-node-in-a-bst/README.md) | 🟡 Medium | [Solution.java](./0450-delete-node-in-a-bst/Solution.java) | Find it, then fix the hole: 0/1 child → splice the child up; 2 children → copy in the **inorder successor** and delete that instead. |
| [701. Insert into a Binary Search Tree](./0701-insert-into-a-binary-search-tree/README.md) | 🟡 Medium | [Solution.java](./0701-insert-into-a-binary-search-tree/Solution.java) | A new value always fits as a **new leaf**: search until you fall off the tree, then hang it there. |
| [1569. Number of Ways to Reorder Array to Get Same BST](./1569-number-of-ways-to-reorder-array-to-get-same-bst/README.md) | 🔴 Hard | [Solution.java](./1569-number-of-ways-to-reorder-array-to-get-same-bst/Solution.java) | Counting orderings that keep two groups' internal order → **binomial coefficient C(L+R, L)**. Use Pascal's triangle to get binomials under a modulus without division. |

[⬅️ Back to all solutions](../README.md)
