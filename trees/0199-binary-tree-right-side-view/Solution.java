import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View  (Medium)
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Intuition: from the right you see exactly ONE node per level: the
 *            rightmost. DFS visiting RIGHT before LEFT reaches the rightmost
 *            node of each depth first, so the first node we meet at a new
 *            depth is the visible one.
 * Time:  O(n)
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        dfs(root, 0, view);
        return view;
    }

    private void dfs(TreeNode node, int depth, List<Integer> view) {
        if (node == null) return;

        if (depth == view.size()) {
            view.add(node.val);         // first node seen at this depth = rightmost
        }
        dfs(node.right, depth + 1, view);   // right first!
        dfs(node.left, depth + 1, view);
    }
}
