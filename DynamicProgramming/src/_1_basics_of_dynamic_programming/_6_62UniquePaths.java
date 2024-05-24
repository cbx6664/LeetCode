package _1_basics_of_dynamic_programming;

import org.junit.Test;

/**
 * ClassName: week2.UniquePaths62
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/27 22:47
 * @Version 1.0
 */
public class _6_62UniquePaths {
    public int uniquePaths(int m, int n) {
        //1.确定dp[]下标的意义
        // dp[m][n]:从(0, 0)到(m, n)的不同路径数
        int [][] dp = new int[m][n];

        //2.确定递推公式
        //因为机器人每次只能向下或向右移动一步，所以到达(i, j)可以算作从(i-1, j)或(i, j-1)移动一步的结果
        //推导公式：dp[i][j] = dp[i-1][j] + dp[i][j-1]

        //3.dp数组如何初始化
        //dp[i][0]和dp[0][j]都只有一条路径
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //4.确定遍历顺序，与机器人运动的轨迹相同，从左往右，从上往下
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];

            }

        }
        return dp[m-1][n-1];
    }

    //5.举例推导验证一下
    @Test
    public void test1(){
        System.out.println(uniquePaths(3, 7));
    }
}
