package _2_bag_problem;

import org.junit.Test;

/**
 * ClassName: MultipleBagProblem
 * Package: week6
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/4 9:09
 * @Version 1.0
 */
public class _27_MultipleBagProblem {
    @Test
    public void test1() {
        System.out.println(mostValue(3, 10, new int[]{1, 3, 4}, new int[]{15, 20, 30}, new int[]{2, 3, 2}));
    }

    public int mostValue(int numOfItem, int bagSpace, int[] weight, int[] value, int[] quantity) {
        //多重背包 与 0-1背包类似, 多重背包里的物品数量各不相同, 但是如果把物品都按数量为1, 一个个算作独立的物品, 就成了0-1背包
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
        //最内层遍历每个物品的数量
        for (int i = 0; i < numOfItem; i++) {
            for (int j = bagSpace; j >= weight[i]; j--) {
                for (int k = 1; k <= quantity[i] && (j - (weight[i] * k)) >= 0; k++) {
                    dp[j] = Math.max(dp[j], dp[j - (weight[i] * k)] + (value[i] * k));
                }
            }
            System.out.println();
            System.out.print("i=" + i + ":");
            System.out.println();
            for (int k = 0; k <= bagSpace; k++) {
                System.out.print(dp[k] + ",");

            }
        }
        System.out.println();
        System.out.println("Finally:");
        for (int i = 0; i <= bagSpace; i++) {
            System.out.print(dp[i] + ",");

        }
        System.out.println();
        return dp[bagSpace];
    }
}

