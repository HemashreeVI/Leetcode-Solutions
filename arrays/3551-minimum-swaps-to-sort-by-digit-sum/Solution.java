import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3551. Minimum Swaps to Sort by Digit Sum  (Medium)
 * https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/
 *
 * Intuition: first work out the target order (sort by digit sum, ties by
 *            value). Then each element must move from its current index to
 *            its target index. Following "where should I go?" arrows splits
 *            the indices into cycles, and a cycle of length L needs L - 1 swaps.
 *            So answer = n - (number of cycles).
 * Time:  O(n log n)  for sorting
 * Space: O(n)
 */
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // 1) build the sorted (target) order
        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted, (a, b) -> {
            int sa = digitSum(a), sb = digitSum(b);
            return sa != sb ? Integer.compare(sa, sb) : Integer.compare(a, b);
        });

        // 2) value -> index where it SHOULD be (values are distinct)
        Map<Integer, Integer> targetIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetIndex.put(sorted[i], i);
        }

        // 3) count cycles of the permutation  i -> targetIndex[nums[i]]
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int cycleLength = 0;
            int j = i;
            while (!visited[j]) {           // walk around the cycle once
                visited[j] = true;
                j = targetIndex.get(nums[j]);
                cycleLength++;
            }
            swaps += cycleLength - 1;       // a cycle of L elements needs L - 1 swaps
        }
        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
