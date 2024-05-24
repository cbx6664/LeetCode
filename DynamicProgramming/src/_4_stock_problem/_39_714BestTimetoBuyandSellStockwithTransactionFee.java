package _4_stock_problem;

import org.junit.Test;

/**
 * ClassName: BestTimetoBuyandSellStockwithTransactionFee714
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/11 9:29
 * @Version 1.0
 */
public class _39_714BestTimetoBuyandSellStockwithTransactionFee {
    @Test
    public void test1(){
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
    public int maxProfit(int[] prices, int fee) {
        //本题与 买卖股票II的区别是: 卖出股票需要手续费, 只需要II的 卖出股票的递推公式 上加上手续费
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
        //dp[i][1] = max(前一天卖的价格, 当天卖的价格 - 手续费) = max(dp[i-1][1], price[i] + dp[i-1][0] - fee)

        //4. 遍历顺序
        //依据递推公式, 当然是顺序遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0] - fee);
        }

        return dp[prices.length - 1][1];

    }
}
