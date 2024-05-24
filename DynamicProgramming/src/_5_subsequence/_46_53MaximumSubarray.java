package _5_subsequence;

import org.junit.Test;

/**
 * ClassName: _46MaximumSubarray53
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/14 18:17
 * @Version 1.0
 */
public class _46_53MaximumSubarray {
    @Test
    public void test1() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        //寻找 和最大 的子数组

        //1.dp[]含义
        //dp[i]:以nums[i]结尾的数组, 其最大连续子序列的和为dp[i]
        int[] dp = new int[nums.length];

        //3.初始化
        //dp[0] = nums[0]
        dp[0] = nums[0];

//        2.递推公式
//        dp[i]只有两个方向可以推出来：
//        dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和
//        nums[i]，即：从头开始计算当前连续子序列和
//        一定是取最大的，所以dp[i] = max(dp[i - 1] + nums[i], nums[i]);

        //4.遍历顺序
        //显然是从小到大遍历
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
