# 2906. Construct Product Matrix

🟡 **Medium** · Matrix / Prefix Product · [Problem on LeetCode](https://leetcode.com/problems/construct-product-matrix/)

## 📝 Problem
For every cell, `p[i][j]` = product of **all other** cells in `grid`, taken **mod 12345**.

## 🧠 Intuition
"Product of everything except me" = **(product of everything before me) × (product of everything after me)**.
That's the same idea as *Product of Array Except Self*; just read the 2D grid as one long row (row by row).

Why not "total product ÷ cell"? Under mod `12345` (not a prime), division doesn't work, and a cell can make the total `0`.

## 🪜 Approach
1. **Forward pass:** keep `prefix` (product of the cells seen so far). Store it in `p[i][j]`, then multiply in `grid[i][j]`.
2. **Backward pass:** keep `suffix` from the end. Multiply `p[i][j]` by it, then multiply in `grid[i][j]`.
3. Use `long` and `% 12345` after every multiplication to avoid overflow.

## 🔁 Flow
```mermaid
flowchart LR
    A["forward: p = prefix, prefix *= cell"] --> B["backward: p *= suffix, suffix *= cell"]
    B --> C["return p"]
```

## 🔍 Dry run
`grid = [[1, 2], [3, 4]]` → flattened `[1, 2, 3, 4]`

| cell | prefix (before) | suffix (after) | p |
|:-:|:-:|:-:|:-:|
| 1 | 1 | 24 | 24 |
| 2 | 1 | 12 | 12 |
| 3 | 2 | 4 | 8 |
| 4 | 6 | 1 | 6 |

Answer: **[[24, 12], [8, 6]]** ✅

## ⏱️ Complexity
| | |
|---|---|
| Time | `O(n · m)` |
| Space | `O(1)` extra |

## 💡 Key takeaway
"Everything except me" → **prefix × suffix**, especially when division isn't allowed.
