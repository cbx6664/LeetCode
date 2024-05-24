package _1_basics_of_dynamic_programming;

import org.junit.Test;

/**
 * ClassName: week1.MinCostClimbingStairs746
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/27 20:53
 * @Version 1.0
 */
public class _4_746MinCostClimbingStairs {
    //正常思路版本
    public int minCostClimbingStairs(int[] cost) {
        //dp[i]:到达第i层的最少消耗量
        //cost[i]:在第i层再运动时的最少消耗量，可以选择跳一层，也可以选择跳两层
        int[] dp = new int[cost.length + 1];
        //可以选择从0，或1出发，意味着到达第0层和到达第1层是没有消耗的
        dp[0] = 0;
        dp[1] = 0;
        //递推公式 dp[i] = min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1])
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Integer.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];

    }

    //高效率版本
//    public int minCostClimbingStairs(int[] cost) {
//        int a = 0;
//        int b = 0;
//        int c = 0;
//        for (int i = 2; i <= cost.length ; i++) {
//            a = Integer.min(b + cost[i-2], c + cost[i-1]);
//            b = c;
//            c = a;
//        }
//        return a;
//    }

    @Test
    public void test1(){
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }
}
