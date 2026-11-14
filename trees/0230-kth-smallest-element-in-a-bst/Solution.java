import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 230. Kth Smallest Element in a BST  (Medium)
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Intuition: an INORDER traversal (left, node, right) of a BST visits the
 *            values in sorted order. So the k-th node we visit inorder IS the
 *            k-th smallest. Do it iteratively with a stack so we can stop the
 *            moment we hit the k-th node instead of walking the whole tree.
 * Time:  O(h + k)  dive down to the smallest, then k steps
 * Space: O(h)      the stack holds one path from the root
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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            // 1. go as far left as possible: smaller values first
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 2. visit the smallest unvisited node
            node = stack.pop();
            if (--k == 0) return node.val;   // this is the k-th one we've seen

            // 3. then everything bigger than it, in its right subtree
            node = node.right;
        }
        return -1;   // unreachable: the problem guarantees 1 <= k <= n
    }
}
