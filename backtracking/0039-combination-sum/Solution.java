import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum  (Medium)
 * https://leetcode.com/problems/combination-sum/
 *
 * Intuition: at each step pick a candidate and subtract it from the
 *            remaining target. A number may be reused, so we recurse with the
 *            SAME start index. Only moving forward (never back to earlier
 *            candidates) avoids duplicates like [2,3] and [3,2].
 * Time:  O(N^(T/M))  roughly; N = candidates, T = target, M = smallest candidate
 * Space: O(T/M)  recursion depth
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start,
                           List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));      // copy, since path keeps changing
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) continue;    // too big, skip

            path.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, path, result);  // i, not i+1: reuse allowed
            path.remove(path.size() - 1);
        }
    }
}
