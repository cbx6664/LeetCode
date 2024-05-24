package _2_bag_problem;

import org.junit.Test;

/**
 * ClassName: week3.LastStoneWeightII1049
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/29 17:02
 * @Version 1.0
 */
public class _14_1049_LastStoneWeightII {
    @Test
    public void twoDimension() {
        System.out.println(lastStoneWeightIITwoDimension(new int[]{31, 26, 33, 21, 40}));

    }


    @Test
    public void oneDimension() {
        System.out.println(lastStoneWeightIIOneDimension(new int[]{31, 26, 33, 21, 40}));
    }

    public int lastStoneWeightIITwoDimension(int[] stones) {
        //采用二维数组实现01背包问题
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }

        int target = sum / 2;
        int backSpace = target;

        int[][] dp = new int[stones.length][backSpace + 1];

        for (int i = 0; i < stones.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= backSpace; j++) {
            if (j >= stones[0]) {
                dp[0][j] = stones[0];
            }
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= backSpace; j++) {
                if (j >= stones[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return sum - 2 * dp[stones.length - 1][target];
    }


    public int lastStoneWeightIIOneDimension(int[] stones) {
        //与分割等和子集类似, 挑选出两个重量相当的子集, 互相砸, 剩下的石头就是最小的
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int target = sum / 2;
        int bagSpace = target;

        //1. dp[j]的含义: 容量为i的背包能装的最大重量
        int[] dp = new int[bagSpace + 1];

        //3. 初始化
        //一维数组解决的01背包问题, 初始化时dp[j]都设为0, 为了保证递推公式不被覆盖

        //2. 递推公式
        //dp[j] = max(dp[j], dp[j - weight[i]] + weight[i])

        //4. 遍历顺序
        //一维数组解决的01背包问题, 外层顺序遍历物品, 内层逆序遍历背包容量, 为了保证物品只添加一次
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[target] - dp[target];

    }
}
