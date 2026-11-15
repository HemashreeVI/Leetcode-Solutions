/**
 * 701. Insert into a Binary Search Tree  (Medium)
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Intuition: a new value always fits as a new LEAF. Walk down like a binary
 *            search (smaller -> left, bigger -> right) until you hit an empty
 *            spot, and hang the new node there. Nothing else has to move.
 *            Done iteratively, so it uses no extra space.
 * Time:  O(h)  one walk from the root down to a leaf
 * Space: O(1)
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) return node;           // empty tree: the new node IS the tree

        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left == null) { cur.left = node; break; }    // empty spot on the left
                cur = cur.left;
            } else {
                if (cur.right == null) { cur.right = node; break; }  // empty spot on the right
                cur = cur.right;
            }
        }
        return root;                             // the root never changes
    }
}
