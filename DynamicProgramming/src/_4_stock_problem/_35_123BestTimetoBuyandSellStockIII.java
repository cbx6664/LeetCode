package _4_stock_problem;

import org.junit.Test;

/**
 * ClassName: BestTimetoBuyandSellStockIII123
 * Package: week7
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/9 11:49
 * @Version 1.0
 */

/*
* You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
* */

public class _35_123BestTimetoBuyandSellStockIII {
    @Test
    public void test1() {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    public int maxProfit(int[] prices) {
        //与前两题相比, 本题最多只让买卖两次, 故本题需要表示五种状态: 1.什么也没做; 2. 第一次持有股票; 3. 第一次不持有股票; 4. 第二次持有股票; 5. 第二次不持有股票
        //1. dp[]数组的含义
        //dp[i][j] 第i天, 状态j时, 所剩的最大现金
        int[][] dp = new int[prices.length][5];

        //3. 初始化
        //dp[0][0] = 0
        //dp[0][1] = -price[0]
        //dp[0][2] = 0
        //dp[0][3] = -price[0]
        //dp[0][4] = 0
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        //2. 递推公式
        //dp[i][1] = 第i天没买入; 第i天买入了 = max(dp[i-1][1], dp[i-1][0] - price[i])
        //dp[i][2] = max(dp[i-1][2], dp[i-1][1] + price[i])
        //dp[i][3] = max(dp[i-1][3], dp[i-1][2] - price[i])
        //dp[i][4] = max(dp[i-1][4], dp[i-1][3] + price[i])

        //4. 遍历顺序
        //依据递推公式, 顺序遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[prices.length - 1][4];

    }
}
