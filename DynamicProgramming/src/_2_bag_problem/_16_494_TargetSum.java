package _2_bag_problem;

import org.junit.Test;

/**
 * ClassName: bag_problem.TargetSum494
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/30 11:37
 * @Version 1.0
 */
public class _16_494_TargetSum {
    /*
You are given an integer array nums and an integer target.
You want to build an expression out of nums
by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1],
you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".

Return the number of different expressions that you can build, which evaluates to target.*/

    @Test
    public void test1() {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        //这是用0-1背包解决组合问题
        // "+" + "-" = Sum of integer array ("+" = [Positive], "-" = [Negative])
        // "+" - "-" = Target
        // "+" = (sum + target) /2
        // 我们要求的是 dp[sum of "+"], 即 装满 正数子集元素的数量 的方法数
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //正(负)子集的和 必须是整数, 若不是整数则无解
        if (((sum + target) % 2) != 0) {
            return 0;
        }

        //因为 正数子集 和 负数子集 元素的和都是大于零的, 所以 sum 大于 target的绝对值
        if (sum < Math.abs(target)) {
            return 0;
        }

        //1. dp[j]的含义: 装满大小为j的 正数子集(背包) 的不同的方法数
        int bagSpace = (sum + target) / 2;
        int[] dp = new int[bagSpace + 1];

        //3. 初始化
        // dp[0] = 1
        // nums = [0], target = 0, "+" = [0], 故正数子集中只有+0, 故只有一种方法
        dp[0] = 1;

        //2. 递推公式
        // dp[j] += dp[j-nums[i]]

        //4. 遍历顺序
        // 一维数组解决背包问题的通用遍历顺序, 外层从0号物品开始顺序遍历, 内层从背包最大容量开始逆序遍历
        for (int i = 0; i < nums.length; i++) {
            System.out.println();
            System.out.println("i = "+i);
            for (int j = bagSpace; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
                System.out.print(dp[j]+",");

            }
        }
        System.out.println();

        return dp[bagSpace];


    }
}
