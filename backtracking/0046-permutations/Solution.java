import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations  (Medium)
 * https://leetcode.com/problems/permutations/
 *
 * Intuition: fill positions one at a time. For each position try every
 *            number that hasn't been used yet. A `used[]` array tells us which
 *            numbers are still available.
 * Time:  O(n * n!)  n! permutations, each copied in O(n)
 * Space: O(n)  recursion + used[] (not counting output)
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));      // full permutation built
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;                  // already placed

            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, result);
            path.remove(path.size() - 1);           // undo
            used[i] = false;
        }
    }
}
