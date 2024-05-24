package _5_subsequence;

import org.junit.Test;

/**
 * ClassName: LongestContinuousIncreasingSubsequence674
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/11 11:46
 * @Version 1.0
 */
public class _42_674LongestContinuousIncreasingSubsequence {
    @Test
    public void test1() {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

    public int findLengthOfLCIS(int[] nums) {
        //本题与 300.最长递增子序列 的区别是: 连续
        //因为要求连续的, 所以不用把 nums[i]之前的所有 nums[j] 与 nums[i]比较, 只需要比较nums[i]的前一个nums[i-1]

        //1. dp数组的含义
        //dp[i]: 以nums[i]结尾的, 最长 !连续! 递增子序列的 长度
        int[] dp = new int[nums.length];
        int result = 1;

        //2. 递推公式
        //if nums[i] > nums[i-1] :dp[i] = dp[j] + 1

        //3. 初始化
        //dp[0] = 1
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        //4. 遍历顺序
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }

            result = Math.max(dp[i], result);

        }
        return result;

    }
}
