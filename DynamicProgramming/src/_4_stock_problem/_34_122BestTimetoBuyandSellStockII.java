package _4_stock_problem;

import org.junit.Test;

/**
 * ClassName: BestTimetoBuyandSellStockII122
 * Package: week7
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/9 10:14
 * @Version 1.0
 */

/*
* You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
* */

public class _34_122BestTimetoBuyandSellStockII {
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
        //这是与121买卖股票唯一的区别
        //这正是因为本题的股票可以买卖多次！ 所以买入股票的时候，可能会有之前买卖的利润即
        //dp[i][0] = max(前一天就持有, 当天刚买入的) = max(dp[i-1][0], dp[i-1][1] - price[i])
        //dp[i][1] = max(前一天卖的价格, 当天卖的价格) = max(dp[i-1][1], price[i] + dp[i-1][0])

        //4. 遍历顺序
        //依据递推公式, 当然是顺序遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[prices.length - 1][1];
    }
}
