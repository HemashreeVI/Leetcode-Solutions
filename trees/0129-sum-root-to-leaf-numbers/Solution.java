/**
 * 129. Sum Root to Leaf Numbers  (Medium)
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Intuition: walking down a path builds a number digit by digit:
 *            current = current * 10 + node.val. At a leaf the number is
 *            complete; add it up. DFS carries `current` down the tree.
 * Time:  O(n)
 * Space: O(h)  recursion depth = tree height
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) return 0;

        current = current * 10 + node.val;          // append this digit
        if (node.left == null && node.right == null) {
            return current;                         // leaf: number is complete
        }
        return dfs(node.left, current) + dfs(node.right, current);
    }
}
