# 🗄️ SQL (Database)

6 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [175. Combine Two Tables](./0175-combine-two-tables/README.md) | 🟢 Easy | [solution.sql](./0175-combine-two-tables/solution.sql) | **INNER JOIN** = only matches. **LEFT JOIN** = all rows from the left table, with NULLs where there's no match. |
| [181. Employees Earning More Than Their Managers](./0181-employees-earning-more-than-their-managers/README.md) | 🟢 Easy | [solution.sql](./0181-employees-earning-more-than-their-managers/solution.sql) | Comparing rows of the **same** table → **self join** with two aliases. |
| [182. Duplicate Emails](./0182-duplicate-emails/README.md) | 🟢 Easy | [solution.sql](./0182-duplicate-emails/solution.sql) | **WHERE** filters rows *before* grouping; **HAVING** filters groups *after* aggregation. |
| [183. Customers Who Never Order](./0183-customers-who-never-order/README.md) | 🟢 Easy | [solution.sql](./0183-customers-who-never-order/solution.sql) | "Rows in A with **no** match in B" → `LEFT JOIN … WHERE B.key IS NULL`. |
| [184. Department Highest Salary](./0184-department-highest-salary/README.md) | 🟡 Medium | [solution.sql](./0184-department-highest-salary/solution.sql) | "Top item per group, keep ties" → **compare with `MAX` per group** (or `RANK()` window function). |
| [196. Delete Duplicate Emails](./0196-delete-duplicate-emails/README.md) | 🟢 Easy | [solution.sql](./0196-delete-duplicate-emails/solution.sql) | "Delete all but one per group" → **self join with `id >`** to point at the extra copies. |

[⬅️ Back to all solutions](../README.md)
