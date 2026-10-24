# 🧮 Dynamic Programming

7 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [32. Longest Valid Parentheses](./0032-longest-valid-parentheses/README.md) | 🔴 Hard | [Solution.java](./0032-longest-valid-parentheses/Solution.java) | For substring problems, define **`dp[i]` = best answer ending at `i`**, then reuse earlier answers to extend. |
| [44. Wildcard Matching](./0044-wildcard-matching/README.md) | 🔴 Hard | [Solution.java](./0044-wildcard-matching/Solution.java) | String-matching with wildcards → **2D DP on prefixes**. For `*`, think "use it for nothing" vs "use it for one more char". |
| [70. Climbing Stairs](./0070-climbing-stairs/README.md) | 🟢 Easy | [Solution.java](./0070-climbing-stairs/Solution.java) | The DP starter problem: **define the state, find the recurrence, keep only what you need**. |
| [118. Pascal's Triangle](./0118-pascals-triangle/README.md) | 🟢 Easy | [Solution.java](./0118-pascals-triangle/Solution.java) | Pascal's triangle gives binomial coefficients `C(n, k)`. It's reused in combinatorics problems like **#1569** in this repo. |
| [198. House Robber](./0198-house-robber/README.md) | 🟡 Medium | [Solution.java](./0198-house-robber/Solution.java) | "Take it or leave it, with a constraint on neighbours" → **include / exclude DP**. |
| [322. Coin Change](./0322-coin-change/README.md) | 🟡 Medium | [Solution.java](./0322-coin-change/Solution.java) | "Minimum number of items to reach a total, items reusable" → **unbounded knapsack DP** over the total. |
| [509. Fibonacci Number](./0509-fibonacci-number/README.md) | 🟢 Easy | [Solution.java](./0509-fibonacci-number/Solution.java) | Overlapping subproblems → **remember results** (memo) or **build bottom-up**. That is what DP means. |

[⬅️ Back to all solutions](../README.md)
