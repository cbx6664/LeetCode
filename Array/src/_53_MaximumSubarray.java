import org.junit.Test;

/**
 * ClassName: _53_MaximumSubarray
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 13/12/24 11:41
 * @Version 1.0
 */
/*
因为是子串问题，所以想到滑动窗口，问题是如何判断窗口满足条件呢？
但是这道题不能用滑动窗口，因为满足条件是动态的，不是静态。

滑动窗口适合解决的问题通常是：
固定窗口大小，例如求固定大小的子数组的最大和。
可变窗口，但有明确的约束条件，例如窗口内字符满足一定频率分布。

滑动窗口通常用于处理固定窗口大小的问题，例如字符串或数组中满足一定条件的子数组。

这道题适合 dp，因为求最大子数组这个任务可分为很多个子任务。

*/
public class _53_MaximumSubarray {
    @Test
    public void test1() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        // dp 5部曲
        // 1.明确 dp[i]含义
        // dp[i]: 以 nums[i]为结尾的数组，最大的 sum
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];

        // 2.递推公式
        // dp[i] = max(dp[i-1] + nums[i], nums[i])
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);

        }

        // 3.dp初始化
        // dp[0] = nums[0]
        // 4.遍历顺序
        // 因为 dp[i]的定义是以 nums[i]为结尾的数组的 最大sum，所以便利顺序是跟着 nums[i]的顺序走的

        // 5.举例推导 dp 数组

        return max;


    }
}
