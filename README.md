<div align="center">

<img src="./banner.svg" alt="LeetCode Solutions — clean Java solutions, one problem at a time" width="100%"/>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=500&size=19&duration=2600&pause=900&color=FFA116&center=true&vCenter=true&width=700&height=40&lines=%E2%98%95+Every+solution+in+clean%2C+commented+Java;%F0%9F%A7%A0+Intuition+first%2C+code+second;%E2%8F%B1%EF%B8%8F+Time+%26+space+complexity+for+every+problem;%F0%9F%8C%B3+Currently+grinding%3A+Binary+Search+Trees;%F0%9F%8E%AF+Next+boss%3A+LeetCode+1569" alt="typing intro"/>

<p>
<img src="https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
<img src="https://img.shields.io/badge/Focus-Trees_&_BSTs-FFA116?style=for-the-badge&logo=leetcode&logoColor=white" alt="focus"/>
<img src="https://img.shields.io/github/last-commit/HemashreeVI/leetcode-solutions?style=for-the-badge&color=00B8A3&label=last%20solved" alt="last commit"/>
</p>

<!-- 📊 PROGRESS: update these three numbers as you solve -->
<p>
<img src="https://img.shields.io/badge/Easy-0-00B8A3?style=flat-square" alt="Easy"/>
<img src="https://img.shields.io/badge/Medium-0-FFC01E?style=flat-square" alt="Medium"/>
<img src="https://img.shields.io/badge/Hard-0-FF375F?style=flat-square" alt="Hard"/>
<img src="https://img.shields.io/badge/Total-0-8B5CF6?style=flat-square" alt="Total"/>
</p>

**[📚 Solutions](#-solutions)** · **[🗂️ By topic](#%EF%B8%8F-by-topic)** · **[🧠 How I write solutions](#-how-i-write-each-solution)** · **[🎯 Goals](#-goals)**

</div>

---

## 📈 Live LeetCode stats

<div align="center">

<!-- Replace LEETCODE_USERNAME (2 places) with your LeetCode username -->
<img src="https://leetcard.jacoblin.cool/LEETCODE_USERNAME?theme=dark&font=Fira%20Code&ext=heatmap" alt="LeetCode stats card"/>

<a href="https://leetcode.com/u/LEETCODE_USERNAME/"><img src="https://img.shields.io/badge/View_my_LeetCode_profile-FFA116?style=for-the-badge&logo=leetcode&logoColor=black" alt="LeetCode profile"/></a>

</div>

## 💡 About this repo

I'm learning data structures and algorithms in **Java**, starting from zero and working towards hard problems. Every solution here is written to be **understood**, not just accepted:

- 🧠 **Intuition first:** the idea in plain words before any code
- 🪜 **Step-by-step approach:** how to get from brute force to optimal
- ⏱️ **Complexity:** time and space for every solution
- 💬 **Commented code:** readable months later, by anyone

## 📚 Solutions

<!-- Add one row per problem. Difficulty badges: 🟢 Easy · 🟡 Medium · 🔴 Hard -->

| # | Problem | Difficulty | Topic | Solution | Time | Space |
|:-:|---|:-:|---|:-:|:-:|:-:|
| 700 | [Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/) | 🟢 Easy | BST | [Java](./trees/0700-search-in-a-bst/Solution.java) | `O(h)` | `O(1)` |
| — | *next problem goes here* | | | | | |

> ✍️ **The row above is an example.** Replace it with the first problem you actually solve, and add a row each time you push a new solution.

## 🗂️ By topic

<table>
<tr>
<td align="center" width="25%">🌳<br/><b>Trees & BST</b><br/><sub><code>/trees</code></sub><br/><img src="https://img.shields.io/badge/solved-0-00B8A3?style=flat-square" alt="trees"/></td>
<td align="center" width="25%">🔢<br/><b>Arrays & Hashing</b><br/><sub><code>/arrays</code></sub><br/><img src="https://img.shields.io/badge/solved-0-00B8A3?style=flat-square" alt="arrays"/></td>
<td align="center" width="25%">👉👈<br/><b>Two Pointers</b><br/><sub><code>/two-pointers</code></sub><br/><img src="https://img.shields.io/badge/solved-0-00B8A3?style=flat-square" alt="two pointers"/></td>
<td align="center" width="25%">🔗<br/><b>Linked Lists</b><br/><sub><code>/linked-lists</code></sub><br/><img src="https://img.shields.io/badge/solved-0-00B8A3?style=flat-square" alt="linked lists"/></td>
</tr>
<tr>
<td align="center">📚<br/><b>Stacks & Queues</b><br/><sub><code>/stacks</code></sub><br/><img src="https://img.shields.io/badge/solved-0-00B8A3?style=flat-square" alt="stacks"/></td>
<td align="center">🔍<br/><b>Binary Search</b><br/><sub><code>/binary-search</code></sub><br/><img src="https://img.shields.io/badge/solved-0-00B8A3?style=flat-square" alt="binary search"/></td>
<td align="center">🕸️<br/><b>Graphs</b><br/><sub><code>/graphs</code></sub><br/><img src="https://img.shields.io/badge/solved-0-00B8A3?style=flat-square" alt="graphs"/></td>
<td align="center">🧮<br/><b>Dynamic Programming</b><br/><sub><code>/dp</code></sub><br/><img src="https://img.shields.io/badge/solved-0-00B8A3?style=flat-square" alt="dp"/></td>
</tr>
</table>

## 🧠 How I write each solution

Every problem gets its own folder with a `Solution.java` and a short `README.md`:

```
trees/
└── 0700-search-in-a-bst/
    ├── Solution.java
    └── README.md      ← intuition, approach, complexity
```

```java
/**
 * 700. Search in a Binary Search Tree  (Easy)
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * Intuition: in a BST, smaller values are always on the left and bigger ones
 *            on the right, so at each node we only need to go ONE way.
 * Time:  O(h)  where h = height of the tree
 * Space: O(1)  iterative, no recursion stack
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (val < root.val) ? root.left : root.right;   // go one way only
        }
        return root;   // the node, or null if not found
    }
}
```

```mermaid
flowchart LR
    A["📖 Read problem"] --> B["🧠 Write intuition<br/>in plain words"]
    B --> C["🐢 Brute force"]
    C --> D["⚡ Optimise"]
    D --> E["✅ Accepted"]
    E --> F["📝 Commit with<br/>complexity notes"]
```

## 🎯 Goals

- [ ] 🌳 Finish the core BST problems (search, insert, delete, validate, k-th smallest)
- [ ] 🧩 Solve **[1569. Number of Ways to Reorder Array to Get Same BST](https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/)** (Hard)
- [ ] 💯 Reach 100 problems solved
- [ ] 🔥 Keep a 30-day streak
- [ ] 📚 Cover all 8 topics above

## 🧰 Tools

<p align="center"><img src="https://skillicons.dev/icons?i=java,idea,vscode,git,github&theme=dark" alt="tools"/></p>

---

<div align="center">

**[Hemashree V I](https://hemashreevi.github.io)** · B.Tech CSE (Cyber Physical Systems), VIT Chennai

<a href="https://hemashreevi.github.io"><img src="https://img.shields.io/badge/Portfolio-8B5CF6?style=flat-square&logo=googlechrome&logoColor=white" alt="Portfolio"/></a>
<a href="https://www.linkedin.com/in/hema-shree-373622289"><img src="https://img.shields.io/badge/LinkedIn-0A66C2?style=flat-square&logo=linkedin&logoColor=white" alt="LinkedIn"/></a>
<a href="https://leetcode.com/u/LEETCODE_USERNAME/"><img src="https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=black" alt="LeetCode"/></a>

<sub>⭐ Star this repo if a solution helped you understand a problem.</sub>

</div>
