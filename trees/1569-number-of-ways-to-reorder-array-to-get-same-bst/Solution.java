import java.util.ArrayList;
import java.util.List;

/**
 * 1569. Number of Ways to Reorder Array to Get Same BST  (Hard)
 * https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
 *
 * Intuition: the first element is the root and must stay first. The rest
 *            split into a LEFT group (smaller) and a RIGHT group (bigger).
 *            Only the relative order INSIDE each group matters; the two
 *            groups can be interleaved freely. Number of interleavings =
 *            C(left + right, left). So
 *                ways(arr) = C(n-1, |left|) * ways(left) * ways(right)
 *            and the answer is ways(nums) - 1 (exclude the original order).
 * Time:  O(n^2)  building Pascal's triangle + splitting at every level
 * Space: O(n^2)  Pascal's triangle
 */
class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[][] comb;      // comb[n][k] = C(n, k) % MOD

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Pascal's triangle: C(i, j) = C(i-1, j-1) + C(i-1, j)
        comb = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        return (int) ((ways(list) - 1 + MOD) % MOD);   // minus the original ordering
    }

    private long ways(List<Integer> arr) {
        if (arr.size() <= 2) return 1;      // 0, 1 or 2 nodes: only one valid order

        int root = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < root) left.add(arr.get(i));    // keeps relative order
            else right.add(arr.get(i));
        }

        long interleavings = comb[arr.size() - 1][left.size()];
        return interleavings * ways(left) % MOD * ways(right) % MOD;
    }
}
