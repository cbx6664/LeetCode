package _5_subsequence;

import org.junit.Test;

/**
 * ClassName: _49DeleteOperationforTwoStrings583
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/15 16:36
 * @Version 1.0
 */
public class _49_583DeleteOperationforTwoStrings {
    @Test
    public void test1() {
        System.out.println(minDistance("sea", "eat"));
    }

    @Test
    public void test2() {
        System.out.println(minDistanceEditDistance("sea", "eat"));
    }

    public int minDistanceEditDistance(String word1, String word2) {
        //本题与48类似, 区别是本题的两个string都可以删除元素

        //1.dp数组的含义
        //dp[i][j]: 以word1[i-1], word2[j-1]结尾的string, 要想达到相等, 所需最少的操作步骤, 每一步都能删除任意string中的任意字符
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //3.初始化
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }

        //2.递推公式
        //1> 如果s[i-1] == t[j-1]:
        // dp[i][j] = dp[i-1][j-1]
        //2> 如果s[i-1] != t[j-1]:
        //dp[i][j] = dp[i-1][j] +1 (编辑word1)
        //dp[i][j] = dp[i][j-1] + 1(编辑word2)
        //dp[i][j] = dp[i-1][j-1] + 2(编辑word1和word2)
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public int minDistance(String word1, String word2) {
        //本题与44题类似, 即
        //text1 与 text2 都进行任意删除操作, 得到的最长的公共子序列
        //word1 + word2的长度 - 最长的公共子序列 = 删除的最少步数

        //首先将string转换成charArray
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        //1.dp数组含义
        //dp[i][j]: 长度∈[0, i-1]的text1 与 长度∈[0,j-1]的text2 的最长公共子序列的长度为dp[i][j]
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

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
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1Array[i - 1] == word2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return word1.length() + word2.length() - dp[word1.length()][word2.length()] * 2;

    }
}
