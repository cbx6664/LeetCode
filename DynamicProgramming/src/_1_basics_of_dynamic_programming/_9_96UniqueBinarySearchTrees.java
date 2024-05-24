package _1_basics_of_dynamic_programming;

import org.junit.Test;

/**
 * ClassName: week2.UniqueBinarySearchTrees96
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/28 19:01
 * @Version 1.0
 */
public class _9_96UniqueBinarySearchTrees {
    public int numTrees(int n) {
        //确定dp数组的含义
        //dp[i]:1~i为结点组成的二叉搜索数的个数
        int [] dp = new int[n+1];
        //确定递推关系
        //dp[i] += dp[以j为头结点，左子树的结点数量] * dp[以j为头结点，右子树的结点数量]
        //j∈[1,i]

        //初始化
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];

    }

    @Test
    public void test1(){
        System.out.println(numTrees(3));
    }
}
