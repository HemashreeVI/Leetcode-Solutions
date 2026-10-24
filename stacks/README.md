# 📚 Stacks

4 problems solved in this topic. Open a problem for the full write-up (intuition, approach, flowchart, dry run, complexity).

| Problem | Difficulty | Code | Key idea |
|---|:-:|:-:|---|
| [20. Valid Parentheses](./0020-valid-parentheses/README.md) | 🟢 Easy | [Solution.java](./0020-valid-parentheses/Solution.java) | Matching / nesting problems → **stack**. Prefer `ArrayDeque` over the old `Stack` class in Java. |
| [150. Evaluate Reverse Polish Notation](./0150-evaluate-reverse-polish-notation/README.md) | 🟡 Medium | [Solution.java](./0150-evaluate-reverse-polish-notation/Solution.java) | Postfix evaluation = **stack of operands**. Watch the operand order for non-commutative ops. |
| [224. Basic Calculator](./0224-basic-calculator/README.md) | 🔴 Hard | [Solution.java](./0224-basic-calculator/Solution.java) | Parentheses = **save state on a stack, solve the inside, restore and combine**. |
| [1614. Maximum Nesting Depth of the Parentheses](./1614-maximum-nesting-depth-of-the-parentheses/README.md) | 🟢 Easy | [Solution.java](./1614-maximum-nesting-depth-of-the-parentheses/Solution.java) | When you only need the stack's **size**, replace the stack with a **counter**. |

[⬅️ Back to all solutions](../README.md)
