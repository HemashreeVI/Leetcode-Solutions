/**
 * 3668. Restore Finishing Order  (Easy)
 * https://leetcode.com/problems/restore-finishing-order/
 *
 * Intuition: `order` already lists everyone in finishing order. Walk through
 *            it and keep only the people who are friends; they come out in
 *            the right order automatically.
 * Time:  O(n + m)
 * Space: O(n)  lookup table for "is this id a friend?"
 */
class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        boolean[] isFriend = new boolean[order.length + 1];   // ids are 1..n
        for (int f : friends) {
            isFriend[f] = true;
        }

        int[] result = new int[friends.length];
        int k = 0;
        for (int id : order) {
            if (isFriend[id]) {
                result[k++] = id;       // friends appear in finishing order
            }
        }
        return result;
    }
}
