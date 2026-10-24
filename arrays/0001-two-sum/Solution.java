import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum  (Easy)
 * https://leetcode.com/problems/two-sum/
 *
 * Intuition: for every number x we need its partner (target - x). If we
 *            remember every number we've already seen in a HashMap, we can
 *            check "have I seen my partner?" in O(1).
 * Time:  O(n)  single pass over the array
 * Space: O(n)  the HashMap can hold up to n numbers
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();   // value -> index

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];                 // the partner we're looking for
            if (seen.containsKey(need)) {
                return new int[] { seen.get(need), i };  // partner came earlier
            }
            seen.put(nums[i], i);                        // remember current number
        }
        return new int[] {};   // problem guarantees one answer, so never reached
    }
}
