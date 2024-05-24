package _5_subsequence;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _52_647PalindromicSubstrings
 * Package: week9
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/16 9:19
 * @Version 1.0
 */
//计算string s中有多少回文子串

public class _52_647PalindromicSubstrings {
    @Test
    public void test1() {
        System.out.println(countSubstringsBF("aba"));
    }

    @Test
    public void test2(){
        System.out.println(countSubstrings("aba"));
    }

    //dp
    public int countSubstrings(String s) {
        char[] sArray = s.toCharArray();

        //1.dp数组的含义
        //dp[i][j]: 元素∈[i,j]的字串是否是回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;//回文字串的数量

        //3.初始化
        //都为false

        //2.递推公式
        //{c, b, a, b, c}
        //i, i+1, , j-1, j
        //dp[i][j]是否是回文子串 可由 dp[i+1][j-1]是否是回文子串判断,
        // 若dp[i+1][j-1] true, s[i]==s[j], dp[i][j] true
        //1> s[i]==s[j]
        //j-i=0, i==j, 只有一个字符, 必定是回文
        //j-i = 1, 两个连续的相同字符, 必定是回文
        //j-i > 1, 看看dp[i+1][j-1]是否true
        //2>s[i]!=s[j]
        //dp[i][j] = false

        //4.遍历顺序
        //dp[i][j] 需要先看 dp[i+1][j-1], 故i从大到小, j从小到大
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (sArray[i] == sArray[j]) {
                    if (j - i <= 1) {
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }


    //暴力法
    public int countSubstringsBF(String s) {
        char[] sArray = s.toCharArray();
        List<Character> result = new LinkedList<>();
        int count = 0;//回文子串的数量


        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int num = 0;//每次内循环字符串中符合回文子串元素 的数量
                result.add(sArray[j]);
                Object[] resultArray = result.toArray();

                //判断是否是回文串
                for (int k = 0; k <= result.size() / 2; k++) {
                    if (resultArray[k] == resultArray[result.size() - 1 - k]) {
                        num++;
                    }
                }

                //字符串中 符合回文字串元素的数量为该字符串的长度, 即可判断为是回文子串
                if (num == result.size() / 2 + 1) {
                    count++;
                }
            }

            result.clear();//每次内循环后清空容器
        }

        return count;

    }
}
