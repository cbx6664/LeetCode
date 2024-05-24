package _2_bag_problem;

import org.junit.Test;

/**
 * ClassName: week3.BagProblem01
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/29 9:18
 * @Version 1.0
 */
public class _11_BagProblem01 {
    @Test
    public void twoDimension() {
        int numOfItem = 3;
        int bagSpace = 8;
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        System.out.println(mostValueTwoDimension(numOfItem, bagSpace, weight, value));
    }

    @Test
    public void oneDimension() {
        int numOfItem = 3;
        int bagSpace = 8;
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        mostValueOneDimension(numOfItem, bagSpace, weight, value);
    }

    //一维数组解决
    public static void mostValueOneDimension(int numOfItem, int bagSpace, int[] weight, int[] value) {
        //1.确定dp[]的下标和含义
        //dp[j]:背包容量为j时，最大的价值
        int[] dp = new int[bagSpace + 1];

        //3.初始化
        dp[0] = 0;
        //dp[j]都初始化为0，因为dp[j] = max(dp[j], (dp[j-weight[i]] + value[i]))，如果dp[j]不为0
        //则会干扰递推公式

        //4.确定遍历顺序
        //j->[0,j]

        //2.确定递推公式
        //有两个方向可推出dp[j]
        //<1>不放物品，dp[j] = dp[j]
        //<2>放物品i，dp[j] = max(dp[j], (dp[j-weight[i]] + value[i]))

        //j逆序遍历的原因是为了保证每个物品只能放一次
        //外层从0号物品顺序遍历
        //内层从背包最大容量逆序遍历
        for (int i = bagSpace; i > 0; i--) {
            for (int j = 0; j < numOfItem; j++) {
                if (i>=weight[j]){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }

            }
            System.out.println();
            System.out.print("i="+i+":");
            System.out.println();
            for (int k = 0; k <= bagSpace; k++) {
                System.out.print(dp[k]+",");

            }
        }
        System.out.println();
        System.out.println("Finally:");
        for (int i = 0; i <= bagSpace; i++) {
            System.out.print(dp[i]+",");
        }
    }


    //二维数组解决
    public static int mostValueTwoDimension(int numOfItem, int bagSpace, int[] weight, int[] value) {
        //1.确定dp[]的下标和含义
        //dp[i][j]:背包容量为j时，在编号为[0,i]的物品里任取，最大的价值
        int[][] dp = new int[numOfItem][bagSpace + 1];

        //3.初始化
        //dp[i][0]:背包容量为0，遍历物品i，价值也为0
        //dp[0][j]:只装0号物品，遍历背包的容量，如果背包容量j>weight[0],则装入，否则装不进去价值还是0
        for (int i = 0; i < numOfItem; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= bagSpace; j++) {
            if (j < weight[0]) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = value[0];
            }
        }

        //4.确定遍历顺序
        //先物品，再背包

        //2.确定递推公式
        //有两个方向可推出dp[i][j]
        //<1>不放物品i，dp[i][j] = dp[i-1][j]
        //<2>放物品i，dp[i][j] = dp[i-1][j-weight[i]] + value[i]
        for (int i = 1; i < numOfItem; i++) {
            for (int j = 1; j <= bagSpace; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i < numOfItem; i++) {
            for (int j = 0; j <= bagSpace; j++) {
                System.out.print(dp[i][j] + ",");

            }
            System.out.println();
        }

        return dp[numOfItem - 1][bagSpace];
    }
}
