/**
 * 1672. Richest Customer Wealth  (Easy)
 * https://leetcode.com/problems/richest-customer-wealth/
 *
 * Intuition: each row is one customer. Sum each row and keep the max.
 * Time:  O(m * n)  every cell is visited once
 * Space: O(1)
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int richest = 0;
        for (int[] customer : accounts) {
            int wealth = 0;
            for (int money : customer) {
                wealth += money;            // total of this customer's bank accounts
            }
            richest = Math.max(richest, wealth);
        }
        return richest;
    }
}
