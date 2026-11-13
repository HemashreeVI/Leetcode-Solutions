/**
 * 98. Validate Binary Search Tree  (Medium)
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Intuition: checking each node only against its own children is NOT enough.
 *            Every node must fit inside a RANGE set by all of its ancestors:
 *            going left caps the max, going right raises the min. Pass that
 *            (low, high) window down the tree and check each node against it.
 * Time:  O(n)  every node visited once
 * Space: O(h)  recursion depth
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
    public boolean isValidBST(TreeNode root) {
        // long bounds, so a node holding Integer.MIN_VALUE / MAX_VALUE still fits
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, long low, long high) {
        if (node == null) return true;                        // empty tree is a valid BST

        if (node.val <= low || node.val >= high) return false; // strictly inside the window

        return valid(node.left, low, node.val)                // left: everything < node.val
            && valid(node.right, node.val, high);             // right: everything > node.val
    }
}
