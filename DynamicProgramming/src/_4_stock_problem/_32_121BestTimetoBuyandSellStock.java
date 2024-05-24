package _4_stock_problem;

import org.junit.Test;

/**
 * ClassName: BestTimetoBuyandSellStock121
 * Package: week7
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/9 9:37
 * @Version 1.0
 */
/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
*/

public class _32_121BestTimetoBuyandSellStock {
    @Test
    public void test1() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        //1. dp[]的含义:
        //dp[i][0]: 第i天, 持有股票时的最多现金
        //dp[i][1]: 第i天, 不持有股票时的最多现金
        int[][] dp = new int[prices.length][2];

        //3. 初始化
        //dp[0][0]: -price[0]
        //dp[0][1]: 0
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        //2. 递推公式
        //dp[i][0] = max(前一天就持有, 当天不持有, 刚买入的) = max(dp[i-1][0], dp[i][1] - price[i])
        //dp[i][1] = max(前一天就不持有; 前一天持有, 当天卖的) = max(dp[i-1][1], price[i] + dp[i-1][0])

        //4. 遍历顺序
        //依据递推公式, 当然是顺序遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[prices.length - 1][1];
    }
}
