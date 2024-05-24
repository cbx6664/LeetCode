package _5_subsequence;

import org.junit.Test;

/**
 * ClassName: LongestIncreasingSubsequence300
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/11 9:45
 * @Version 1.0
 */
public class _41_300LongestIncreasingSubsequence {
    @Test
    public void test1() {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        //1. dp数组的含义
        //dp[i]: 以nums[i]结尾的, 最长递增子序列的 长度
        int[] dp = new int[nums.length];
        int result = 1;

        //2. 递推公式
        //if nums[i] > nums[j] :dp[i] = max(dp[i], dp[j] + 1), j<i

        //3. 初始化
        //dp[0] = 1
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        //4. 遍历顺序
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //这里要求max(dp[i], dp[j]+1)是因为dp[i]在内层循环多次, dp[j]有时会出现倒挂, 所以必须求最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);

        }
        return result;

    }
}
