package _5_subsequence;

import org.junit.Test;

/**
 * ClassName: _50EditDistance72
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/15 17:04
 * @Version 1.0
 */
public class _50_72EditDistance {
    @Test
    public void test1() {
        System.out.println(minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        //将word1 转换成 word2所使用的最少操作数
        //可以进行三种操作, 插入一个字符; 删除一个字符; 替换一个字符

        //转换为字符数组
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        //1.dp数组的含义
        //dp[i][j]: 以word1[i-1]结尾的string 和 word2[j-1]结尾的string, 最近的编辑距离为dp[i][j]
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //3.初始化
        //dp[i][0]: 以word1[i-1]结尾的string, 要想转变为空string, 最少的操作数, 当然是i
        //dp[0][j]: 同理
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        //2.递推公式
        //1>word1[i-1] == word2[j-1]
        //dp[i][j] = dp[i-1][j-1]
        //2>word1[i-1] != word2[j-1]
        //dp[i][j] = dp[i-1][j] + 1 (删除word1中的一个元素)
        //dp[i][j] = dp[i][j-1] + 1 (添加word1中的一个元素, 因为在word2中删除就相当于在word1中添加)
        //dp[i][j] = dp[i-1][j-1] + 1 (替换word1[i-1]的元素, 使其与word2[j-1]相同)

        //4.遍历顺序
        //根据递推公式, 从上到下, 从左到右遍历
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1Array[i - 1] == word2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];


    }
}
