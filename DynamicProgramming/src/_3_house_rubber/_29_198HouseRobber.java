package _3_house_rubber;

import org.junit.Test;

/**
 * ClassName: HouseRobber198
 * Package: week7
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/4 11:14
 * @Version 1.0
 */

/*You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected,
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.*/

public class _29_198HouseRobber {
    @Test
    public void test1() {
        System.out.println(rob(new int[]{2,1,1,2}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //1. dp数组的含义
        //dp[i]: 考虑 下标为[0,i]的房子, 最多偷的钱数
        int[] dp = new int[nums.length];

        //3. 初始化
        //看递推公式, dp[0]和dp[1]不能为0, 其他的都为0
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        //2. 递推公式
        //下标为i的房子偷不偷 取决于 前一所 和 前两所 房子是否被偷
        //若前一所被偷了, 就不能偷了, dp[i] = dp[i-1]
        //若前一所没被偷, dp[i] = dp[i-2] + nums[i]

        //4.遍历顺序
        //递推公式是从前向后遍历, 因此 顺序遍历
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        }
        return dp[nums.length - 1];

    }
}
