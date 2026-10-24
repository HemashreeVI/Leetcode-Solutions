/**
 * 121. Best Time to Buy and Sell Stock  (Easy)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Intuition: if I sell today, the best day to have bought is the cheapest
 *            day BEFORE today. So keep track of the minimum price seen so
 *            far and check today's profit against it.
 * Time:  O(n)  one pass
 * Space: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;   // cheapest buy price so far
        int best = 0;                       // best profit so far (0 = don't trade)

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;                       // found a cheaper day to buy
            } else {
                best = Math.max(best, price - minPrice); // try selling today
            }
        }
        return best;
    }
}
