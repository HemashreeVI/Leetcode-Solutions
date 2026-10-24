/**
 * 509. Fibonacci Number  (Easy)
 * https://leetcode.com/problems/fibonacci-number/
 *
 * Intuition: F(n) = F(n-1) + F(n-2). Naive recursion recomputes the same
 *            values again and again; building up from the bottom with two
 *            variables computes each value exactly once.
 * Time:  O(n)
 * Space: O(1)
 */
class Solution {
    public int fib(int n) {
        if (n < 2) return n;            // F(0) = 0, F(1) = 1

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
