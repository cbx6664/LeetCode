package _2_bag_problem;

import org.junit.Test;

/**
 * ClassName: CoinChange
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/2 10:30
 * @Version 1.0
 */

/*
* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
* */

public class _23_322_CoinChange {
    @Test
    public void test1() {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        //本题和之前的coinChangeII 518 相似, 不同之处在于 本题要求所用物品最少的组合, 518要求所有的组合

        //1. dp[]的含义
        //dp[j]: 装满容量为j的背包, 所需最少的物品数量为dp[j]
        int[] dp = new int[amount + 1];

        //3.初始化
        //dp[0] = 0, 因为dp[]定义, 装满容量为0的背包, 所需最少的物品数量就是0
        //因为有min(), 其他的dp[j]应为初始化为最大值, 若都为0则无法更新
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        //2.递推公式
        //dp[j] = dp[j-coins[i]] + 1 ;因为要求最小, 故需要 min
        //dp[j] = min(dp[j-coins[i]]+1, dp[j])

        //3. 遍历次序
        //物品可重复使用, 完全背包, 内循环遍历背包容量时 顺序遍历
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        //外层循环背包容量, 内层循环物品的情况
//        for (int i = 0; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (i >= coins[j]) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
