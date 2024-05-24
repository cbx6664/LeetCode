package _3_house_rubber;

import org.junit.Test;

/**
 * ClassName: HouseRobberII213
 * Package: week7
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/4 16:24
 * @Version 1.0
 */
/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
* */

public class _30_213HouseRobberII {
    @Test
    public void test1() {
        System.out.println(rob(new int[]{0,0}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        //1. dp数组的含义
        //dp[i]: 考虑 下标为[0,i]的房子, 最多能偷的钱数
        int[] dp = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];

        //3. 初始化
        //看递推公式, dp[0]和dp[1]不能为0, 其他的都为0
        //考虑头, 不考虑尾
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //不考虑头, 考虑尾
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);


        //2. 递推公式
        //下标为i的房子偷不偷 取决于 前一所 和 前两所 房子是否被偷
        //若前一所被偷了, 就不能偷了, dp[i] = dp[i-1]
        //若前一所没被偷, dp[i] = dp[i-2] + nums[i]

        //4.遍历顺序
        //递推公式是从前向后遍历, 因此 顺序遍历
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        for (int i = 3; i < nums.length; i++) {
            dp2[i - 1] = Math.max(dp2[i - 2], dp2[i - 3] + nums[i]);
        }

        return Math.max(dp[nums.length - 2], dp2[nums.length - 2]);
    }
}
