package _4_stock_problem;

import org.junit.Test;

/**
 * ClassName: BestTimetoBuyandSellStockwithCooldown309
 * Package: week7
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/10 19:52
 * @Version 1.0
 */

/*
* You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
* */

public class _37_309BestTimetoBuyandSellStockwithCooldown {
    @Test
    public void test1() {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        //本题在 买卖股票II 的基础上, 又加了限制条件, 卖出股票之后的第二天是冻结期, 不能进行任何操作

        //1. dp[]的含义:
        //dp[i][j]: 第i天, 状态为j时的最多现金
        int[][] dp = new int[prices.length][4];

        //3. 初始化
        //dp[0][0]: 第一天持有股票, -prices[0]
        //dp[0][1]: 第一天是 持续卖出状态, 不可能
        //dp[0][2]: 第一天是 刚卖出状态, 不可能
        //dp[0][3]: 第一天是 冻结期, 不可能
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        //2. 递推公式
        //本题有几个状态
        //1).持有股票状态(今天买入(1>昨天是冻结状态 2>昨天是 持续卖出状态) / 之前买入的,一直保持买入状态)
        //dp[i][0] = max(dp[i-1][3] - price[i], dp[i-1][1] - price[i], dp[i-1][0])

        //2).不持有股票
        //2.1 持续卖出状态: 两天前就卖出了, 即前一天是冻结期 / 前一天就是保持卖出状态
        //dp[i][1] = max(dp[i-1][3], dp[i-1][1])

        //2.2 今天刚卖出(1>昨天是持有股票状态)
        //dp[i][2] = dp[i-1][0] + price[i]

        //3).冻结期状态(昨天卖出的股票, 现在正处于冻结期)
        //dp[i][3] = dp[i-1][2]


        //4. 遍历顺序
        //依据递推公式, 当然是顺序遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]), dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][3], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }

        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));


    }


}
