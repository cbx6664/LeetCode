package _2_bag_problem;

import org.junit.Test;

/**
 * ClassName: bag_problem.CombinationSumIV377
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/2 9:35
 * @Version 1.0
 */

/*
* Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
* */

public class _21_377_CombinationSumIV {

    @Test
    public void test1() {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        //1. dp数组的含义
        //dp[j]: 背包容量为j时, 装满背包的不同的方法的 排列数
        int[] dp = new int[target + 1];

        //3.初始化
        //dp[0] = 1
        dp[0] = 1;

        //2. 递推公式
        //在494.TargetSum中, 用到了dp[j] += dp[j - num[i]]
        //这里也可以用

        //4.遍历顺序
        //求排列数时要外层顺序遍历背包容量, 内层顺序遍历物品
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        return dp[target];


    }
}
