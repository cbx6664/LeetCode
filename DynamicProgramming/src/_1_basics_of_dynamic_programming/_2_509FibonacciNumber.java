package _1_basics_of_dynamic_programming;

import org.junit.Test;

/**
 * ClassName: week1.FibonacciNumber509
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/3/26 17:30
 * @Version 1.0
 */
public class _2_509FibonacciNumber {
    //非压缩状态的版本
    public int fib(int n) {
        if (n <= 1) {return n;}
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 2; index <= n; index++){
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }
    
    @Test
    public void test1(){
        System.out.println(fib(5));
    }


    //压缩状态的版本
    public int fib1(int n) {
        if (n <= 1) {return n;}
        //没必要在内存中存储个数组，因为递推公式中只有三个数在进行运算，存这三个数就够了
//        int[] dp = new int[n + 1];

        //f(0),f(1)时的值, f(n)的值
        int a = 0;
        int b = 1;
        int c = 0;
        for (int index = 2; index <= n; index++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    @Test
    public void test2(){
        System.out.println(fib1(5));
    }
}

