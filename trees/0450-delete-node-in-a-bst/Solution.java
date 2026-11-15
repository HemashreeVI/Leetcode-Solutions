/**
 * 450. Delete Node in a BST  (Medium)
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * Intuition: use the BST order to FIND the node (go left if key is smaller,
 *            right if bigger). Deleting it has three cases:
 *              - no children   -> just remove it
 *              - one child     -> the child takes its place
 *              - two children  -> copy in its inorder SUCCESSOR (the smallest
 *                                 value in the right subtree), then delete
 *                                 that successor from the right subtree.
 *            The successor is bigger than everything on the left and smaller
 *            than everything else on the right, so the BST order still holds.
 * Time:  O(h)  one walk down to the node, one more down to its successor
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;                    // key not in the tree

        if (key < root.val) {
            root.left = deleteNode(root.left, key);        // it's somewhere on the left
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);      // ...or on the right
        } else {
            // found it
            if (root.left == null) return root.right;      // 0 or 1 child: the child moves up
            if (root.right == null) return root.left;

            TreeNode succ = root.right;                    // 2 children: smallest on the right
            while (succ.left != null) succ = succ.left;
            root.val = succ.val;                           // take the successor's value
            root.right = deleteNode(root.right, succ.val); // and remove the successor
        }
        return root;
    }
}
