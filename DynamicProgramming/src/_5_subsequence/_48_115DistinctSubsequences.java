package _5_subsequence;

import org.junit.Test;

/**
 * ClassName: _48DistinctSubsequences115
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/14 20:02
 * @Version 1.0
 */
public class _48_115DistinctSubsequences {
    @Test
    public void test1() {
        System.out.println(numDistinct("baegg", "bag"));
    }

    public int numDistinct(String s, String t) {
        //母串s经过任意删除, 字串t与修改后的s 相同的次数

        //1.dp数组的含义
        //dp[i][j]: s[0, i-1]经过任意删除元素后, 包含的t[0, j-1]的个数
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        //3.初始化
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        //2.递推公式
        //1> 如果s[i-1] == t[j-1](s和t的尾元素一样):
        // dp[i][j] = dp[i-1][j-1](使用s[i-1]与t[j-1]匹配) + dp[i-1][j](不使用s[i-1]与t[j-1]匹配)
        //2> 如果s[i-1] != t[j-1](s和t的尾元素不一样):
        //dp[i][j] = dp[i-1][j](不使用s[i-1]与t[j-1]匹配, 只能删母串s)
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];


    }
}
