package _1_basics_of_dynamic_programming;

import org.junit.Test;

/**
 * ClassName: week1.ClimbingStairs70
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/27 16:12
 * @Version 1.0
 */
public class _3_70ClimbingStairs {
    public int climbStairs70(int n) {
        if(n == 1){return 1;}
        else if(n == 2){return 2;}
        else{
            //dp[i] = dp[i-1] + dp[i-2]
            int a = 0;
            int b = 2;
            int c = 1;
            for(int i = 3; i<=n; i++){
                a = b + c;
                c = b;
                b = a;
            }
            return a;
        }

    }

    @Test
    public void test1(){
        System.out.println(climbStairs70(3));
    }
}
