/**
 * 169. Majority Element  (Easy)
 * https://leetcode.com/problems/majority-element/
 *
 * Intuition (Boyer-Moore Voting): the majority element appears more than
 *            n/2 times. If every other element "cancels out" one copy of it,
 *            the majority still has copies left at the end.
 * Time:  O(n)
 * Space: O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;               // pick a new candidate
            }
            count += (num == candidate) ? 1 : -1;  // vote for or against it
        }
        return candidate;   // guaranteed to exist, so the survivor is the answer
    }
}
