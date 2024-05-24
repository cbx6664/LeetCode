package _5_subsequence;

import org.junit.Test;

/**
 * ClassName: _53_516LongestPalindromicSubsequence
 * Package: week9
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/16 11:05
 * @Version 1.0
 */
//求最长的回文子序列, 与回文子串不同, 回文子序列可以是不连续的元素构成的

public class _53_516LongestPalindromicSubsequence {
    @Test
    public void test1() {
        System.out.println(longestPalindromeSubseq("abccba"));
    }

    public int longestPalindromeSubseq1(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }


    public int longestPalindromeSubseq(String s) {
        char[] sArray = s.toCharArray();

        //1.dp数组含义
        //dp[i][j]:string s∈[i,j], 其中最长的回文子序列的长度
        int[][] dp = new int[s.length()][s.length()];

        //2.递推公式
        //1>s[i]==s[j]
        //dp[i][j] = dp[i+1][j-1] + 2
        //2>s[i]!=s[j]
        //dp[i][j] = max(dp[i][j-1], dp[i+1][j])

        //3.初始化
        //dp[i][i] = 1, 长度为1的字符串肯定是回文串

        //4.遍历顺序
        //由递推公式可知, i从大到小, j从小到大
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (sArray[i] == sArray[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
