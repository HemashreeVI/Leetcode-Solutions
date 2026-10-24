/**
 * 114. Flatten Binary Tree to Linked List  (Medium)
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Intuition (Morris-style): for each node with a left subtree, the LAST node
 *            of that left subtree in preorder (its rightmost node) should
 *            point to the node's current right child. So: find that rightmost
 *            node, hook the right subtree onto it, move the left subtree to
 *            the right, and continue down the right.
 * Time:  O(n)  each edge is walked a constant number of times
 * Space: O(1)  no recursion, no stack
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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // rightmost node of the left subtree = last node before curr.right in preorder
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = curr.right;   // attach the original right subtree
                curr.right = curr.left;         // move the left subtree to the right
                curr.left = null;
            }
            curr = curr.right;                  // continue down the "list"
        }
    }
}
