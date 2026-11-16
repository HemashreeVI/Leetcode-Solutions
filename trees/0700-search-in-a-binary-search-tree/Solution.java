/**
 * 700. Search in a Binary Search Tree  (Easy)
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * Intuition: the BST rule tells you which way to go at every node: smaller
 *            values live on the left, bigger ones on the right. So you never
 *            explore both sides; it's binary search on a tree. Each step
 *            throws away a whole subtree.
 * Time:  O(h)  one path from the root down
 * Space: O(1)  a loop, no recursion
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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null && cur.val != val) {
            cur = val < cur.val ? cur.left : cur.right;   // the BST rule picks the side
        }
        return cur;   // the matching node (its whole subtree comes with it), or null
    }
}
