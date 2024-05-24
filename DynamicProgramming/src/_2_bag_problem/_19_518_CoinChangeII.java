package _2_bag_problem;

import org.junit.Test;

/**
 * ClassName: bag_problem.CoinChangeII518
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/31 16:59
 * @Version 1.0
 */

/*
* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
* */
public class _19_518_CoinChangeII {
    @Test
    public void test1() {
        System.out.println(change(5, new int[]{1, 2, 5}));

    }

    @Test
    public void test2(){
        System.out.println(changePermutation(4, new int[]{1, 2, 3}));
    }

    public int changePermutation(int amount, int[] coins) {
        //494. TargetSum 和这个类似, 只不过这个的物品不限量
        //老规矩, dp五部曲

        //1. dp数组的含义
        //dp[j]: 背包容量为j时, 装满背包的不同的方法数
        int[] dp = new int[amount + 1];

        //3.初始化
        //dp[0] = 1
        dp[0] = 1;

        //2. 递推公式
        //在494.TargetSum中, 用到了dp[j] += dp[j - num[i]]
        //这里也可以用

        //4.遍历顺序
        //求排列数时要外层顺序遍历背包容量, 内层顺序遍历物品
        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[amount];

    }


    public int change(int amount, int[] coins) {
        //494. TargetSum 和这个类似, 只不过这个的物品不限量
        //老规矩, dp五部曲

        //1. dp数组的含义
        //dp[j]: 背包容量为j时, 装满背包的不同的方法数
        int[] dp = new int[amount + 1];

        //3.初始化
        //dp[0] = 1
        dp[0] = 1;

        //2. 递推公式
        //在494.TargetSum中, 用到了dp[j] += dp[j - num[i]]
        //这里也可以用

        //4.遍历顺序
        //一维数组解决完全背包的通用遍历顺序
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];

    }
}
