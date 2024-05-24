package _2_bag_problem;

import org.junit.Test;

/**
 * ClassName: bag_problem.OnesAndZeroes474
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/31 9:53
 * @Version 1.0
 */
public class _17_474_OnesAndZeroes {
    @Test
    public void test1() {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 3, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        //0-1背包的应用, 给定背包容量, 装满背包最多有多少个物品
        //只不过这个背包有两个维度, 装0的容量为m, 装1的容量为n

        //1.dp[]的含义, dp[i][j]:最多装i个0, j个1的背包, 最多的物品数量是dp[i][j]

        //3.初始化
        //dp[0][0] = 0, 容量都为0, 物品数量肯定是0
        // dp[i][j]都为0即可, 不要干扰递推公式即可
        int[][] dp = new int[m + 1][n + 1];

        //2.递推公式
        //dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)

        //4.遍历顺序
        //与一维数组接解决01背包问题类似, 最外层顺序遍历 物品, 内层逆序遍历背包容量, 只不过这个背包有两个维度的容量
        for (String str : strs) {
            int zeroNum = 0;
            int oneNum = 0;

            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            System.out.println("i="+i+",");
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println();

        }

        return dp[m][n];
    }
}
