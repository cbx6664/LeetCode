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
* You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
* */

public class _36_188BestTimetoBuyandSellStockIV {
    @Test
    public void test1() {
        System.out.println(maxProfit(2, new int[]{1,2,3,4,5}));
    }

    public int maxProfit(int k, int[] prices) {
        //本题相比III, 在于规定了最多买卖k次, 故表示状态的数组大小为2k+1
        //1. dp[]数组的含义
        //dp[i][j] 第i天, 状态j时, 所剩的最大现金
        int[][] dp = new int[prices.length][2 * k + 1];

        //3. 初始化
        //dp[0][0] = 0
        //dp[0][1] = -price[0]
        //dp[0][2] = 0
        //dp[0][3] = -price[0]
        //dp[0][4] = 0
        for (int i = 0; i < k; i++) {
            dp[0][2 * i + 1] = -prices[0];
        }

        //2. 递推公式
        //dp[i][1] = 第i天没买入; 第i天买入了 = max(dp[i-1][1], dp[i-1][0] - price[i])
        //dp[i][2] = max(dp[i-1][2], dp[i-1][1] + price[i])
        //dp[i][3] = max(dp[i-1][3], dp[i-1][2] - price[i])
        //dp[i][4] = max(dp[i-1][4], dp[i-1][3] + price[i])

        //4. 遍历顺序
        //依据递推公式, 顺序遍历
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][2 * j - 1] = Math.max(dp[i - 1][2 * j - 1], dp[i - 1][2 * j - 2] - prices[i]);
                dp[i][2 * j] = Math.max(dp[i - 1][2 * j], dp[i - 1][2 * j - 1] + prices[i]);
            }
        }

        return dp[prices.length - 1][2 * k];
    }
}
