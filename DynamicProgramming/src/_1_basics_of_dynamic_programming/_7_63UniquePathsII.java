package _1_basics_of_dynamic_programming;

import org.junit.Test;

/**
 * ClassName: week2.UniquePathsII63
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/28 9:29
 * @Version 1.0
 */
public class _7_63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        //1.确定dp[]下标的意义
        // dp[m][n]:从(0, 0)到(m, n)的不同路径数
        int [][] dp = new int[m][n];

        //2.确定递推公式
        //因为机器人每次只能向下或向右移动一步，所以到达(i, j)可以算作从(i-1, j)或(i, j-1)移动一步的结果
        //推导公式：dp[i][j] = dp[i-1][j] + dp[i][j-1]

        //3.dp数组如何初始化
        //dp[i][0]和dp[0][j]都只有一条路径
        //一旦遇到obstacleGrid[i][0] == 1的情况就停止dp[i][0]的赋值1的操作，dp[0][j]同理
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        //4.确定遍历顺序，与机器人运动的轨迹相同，从左往右，从上往下
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //如果遇到障碍物则跳过，没有障碍物时再推导
                if (obstacleGrid[i][j] == 1) {dp[i][j] = 0;}
                else {dp[i][j] = dp[i-1][j] + dp[i][j-1];}
            }

        }
        return dp[m-1][n-1];

    }

    @Test
    public void test1(){
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
    
    @Test
    public void test2(){
        int[][] arr= new int[][] {{0,0,0},{0,1,0},{0,0,0}};
    }
}
