package _5_subsequence;

import org.junit.Test;

/**
 * ClassName: _1035UncrossedLines
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/14 17:57
 * @Version 1.0
 */
public class _45_1035UncrossedLines {
    @Test
    public void test1() {
        System.out.println(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //本题的本质就是求 最长公共子序列, 与44一样
        //即 text1 与 text2 都进行任意删除操作, 得到的最长的公共子序列

        //1.dp数组含义
        //dp[i][j]: 长度∈[0, i-1]的text1 与 长度∈[0,j-1]的text2 的最长公共子序列的长度为dp[i][j]
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        //3.初始化
        //dp[i][0] = 0
        //dp[0][j] = 0
        //其他的下标都会随着递推被覆盖, 都初始化为0即可


        //2.递推公式
        //两大情况:text1[i-1]==text2[j-1]; text1[i-1]!=text2[j-1]
        //若text1[i-1]==text2[j-1], 则dp[i][j] = dp[i-1][j-1] +1
        //若text1[i-1]!=text2[j-1], 则dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        //由前往后推

        //4.遍历顺序
        //根据递推公式, 从小到大
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];


    }
}
