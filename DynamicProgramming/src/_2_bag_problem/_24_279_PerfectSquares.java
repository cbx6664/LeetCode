package _2_bag_problem;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: bag_problem.PerfectSquares279
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/3 9:10
 * @Version 1.0
 */

/*
* Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer;
* in other words, it is the product of some integer with itself.
* For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
* */

public class _24_279_PerfectSquares {

    @Test
    public void test1() {
        System.out.println(numSquares(4));
    }

    public int numSquares(int n) {
        //完全背包问题的应用, nums[] = {1,2,3,4,...}, 物品的重量是 平方值, 价值是 原始值.
        //dp[j]: 和为j的完全平方数的最小数量

        int bagSpace = n;
        int[] dp = new int[bagSpace + 1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= bagSpace; j++) {
                dp[j] = Math.min(dp[j], dp[j - (i*i)] + 1);
            }
        }
        return dp[bagSpace];
    }

}
