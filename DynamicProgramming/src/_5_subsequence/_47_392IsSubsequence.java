package _5_subsequence;


import org.junit.Test;

/**
 * ClassName: _47IsSubsequence392
 * Package: week8
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/14 18:40
 * @Version 1.0
 */
public class _47_392IsSubsequence {
    @Test
    public void test1(){
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        //本题与44最长公共子序列1143类似
        //不同之处在于: 44中, text1 与 text2 都进行任意删除操作, 得到的最长的公共子序列的长度
        //本题中, 只有t能任意删除操作, 因为t是母串, s是字串

        //首先将string转换成charArray
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        //1.dp数组含义
        //dp[i][j]: 长度∈[0, i-1]的text1 与 长度∈[0,j-1]的text2 的最长公共子序列的长度为dp[i][j]
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        //3.初始化
        //dp[i][0] = 0
        //dp[0][j] = 0
        //其他的下标都会随着递推被覆盖, 都初始化为0即可


        //2.递推公式
        //两大情况:text1[i-1]==text2[j-1]; text1[i-1]!=text2[j-1]
        //若text1[i-1]==text2[j-1], 则dp[i][j] = dp[i-1][j-1] +1
        //若text1[i-1]!=text2[j-1], 则dp[i][j] = dp[i][j-1](只能删除t的元素)
        //由前往后推

        //4.遍历顺序
        //根据递推公式, 从小到大
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (sArray[i - 1] == tArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[s.length()][t.length()] == s.length();


    }
}
