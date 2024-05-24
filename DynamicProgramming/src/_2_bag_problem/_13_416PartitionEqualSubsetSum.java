package _2_bag_problem;

import org.junit.Test;

/**
 * ClassName: week3.PartitionEqualSubsetSum416
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/29 11:01
 * @Version 1.0
 */
public class _13_416PartitionEqualSubsetSum {
    //Given an integer array nums,
    // return true if you can partition the array into two subsets
    // such that the sum of the elements in both subsets is equal or false otherwise.
    //Example 1:
    //Input: nums = [1,5,11,5]
    //Output: true
    //Explanation: The array can be partitioned as [1, 5, 5] and [11].
    @Test
    public void test1() {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartitionBetter(new int[]{1, 5, 11, 5}));
    }

    //优化运行速度
    public boolean canPartitionBetter(int[] nums) {
        //用01背包解决此问题，题目要求把数组分割成两个元素和相同的子数组
        //故用一个背包装数字，若这个背包中的数字的和是sum/2，则说明可以分割
        //01背包问题中，有物品的重量(数字的值),物品的价值(数字的值)

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int target = sum / 2;

        //若数组中元素的和不能平均分，则不能拆成两个和相等的子数组
        if (sum % 2 != 0) {
            return false;
        }

        int bagSpace = target;
        int[] dp = new int[bagSpace + 1];


        //dp[i]:背包容量为i时的最大价值（数字的和）
        dp[0] = 0;

        //一维数组解决01背包问题的模板
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSpace; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            //每完成一次内层循环, 就检查下是否已经分割好, 优化运行时间
            if (dp[target] == target) {
                return true;
            }
        }

        return false;
    }

    //普通版本
    public boolean canPartition(int[] nums) {
        //用01背包解决此问题，题目要求把数组分割成两个元素和相同的子数组
        //故用一个背包装数字，若这个背包中的数字的和是sum/2，则说明可以分割
        //01背包问题中，有物品的重量(数字的值),物品的价值(数字的值)

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int target = sum / 2;

        //若数组中元素的和不能平均分，则不能拆成两个和相等的子数组
        if (sum % 2 != 0) {
            return false;
        }

        int bagSpace = target;
        int[] dp = new int[bagSpace + 1];


        //dp[i]:背包容量为i时的最大价值（数字的和）
        dp[0] = 0;

        //一维数组解决01背包问题的模板
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSpace; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        for (int i = 0; i <= bagSpace; i++) {
            if (dp[i] == target) {
                return true;
            }
        }

        return false;
    }

}
