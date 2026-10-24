# 2667. Create Hello World Function

🟢 **Easy** · JavaScript / Closures · [Problem on LeetCode](https://leetcode.com/problems/create-hello-world-function/)

> ℹ️ Part of LeetCode's **30 Days of JavaScript**. It only accepts JavaScript/TypeScript, so this solution is in JS.

## 📝 Problem
Write `createHelloWorld` that **returns a function**, and that returned function always returns `"Hello World"`, whatever arguments it's called with.

## 🧠 Intuition
In JavaScript, functions are **values**: you can return them like a number or a string. So `createHelloWorld` just returns a new function whose body is `return "Hello World"`.

*(Java analogy: returning a lambda, e.g. `Supplier<String> f = () -> "Hello World";`.)*

## 🪜 Approach
1. Define `createHelloWorld`.
2. Inside, return `function(...args) { return "Hello World"; }`.

## 🔁 Flow
```mermaid
flowchart LR
    A["createHelloWorld()"] --> B["returns function f"]
    B --> C["f(anything)"]
    C --> D["'Hello World'"]
```

## 🔍 Dry run
```js
const f = createHelloWorld();
f();            // "Hello World"
f({}, null, 42) // "Hello World"
```

## ⏱️ Complexity
| | |
|---|---|
| Time | `O(1)` |
| Space | `O(1)` |

## 💡 Key takeaway
**Higher-order functions**: functions that return (or take) other functions. This is the foundation of closures.
