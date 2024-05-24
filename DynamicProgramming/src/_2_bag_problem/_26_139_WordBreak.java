package _2_bag_problem;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

/**
 * ClassName: WordBreak139
 * Package: week6
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/3 10:52
 * @Version 1.0
 */

/*
* Given a string s and a dictionary of strings wordDict,
* return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
* */

public class _26_139_WordBreak {

    @Test
    public void test1() {
        System.out.println(wordBreak("aaaaaaa", List.of(new String[]{"aaaa", "aaa"})));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //完全背包的应用
        //s是背包, wordDict是物品

        //1. dp[]的含义
        //dp[i]: 长度为i的字符串 能否被 wordDict中的单词填满, return true or false

        //3. 初始化
        //dp[0] =  1, 没意义, 只是为了推导公式
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        //2. 递推公式
        //如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）
        //所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true

        //4. 遍历顺序
        //物品是"leet, code", 背包是"leetcode", 所以次序必须是"leet", "code"才行
        //所以求的是排列数, 外层从0顺序遍历背包, 内层从0顺序遍历物品
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];

    }
}
