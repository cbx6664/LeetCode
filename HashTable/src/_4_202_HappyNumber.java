import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: _4_202_HappyNumber
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/24 14:49
 * @Version 1.0
 */

/*「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

如果 n 是快乐数就返回 True ；不是，则返回 False 。

示例：

输入：19
输出：true
解释：
        1^2 + 9^2 = 82
        8^2 + 2^2 = 68
        6^2 + 8^2 = 100
        1^2 + 0^2 + 0^2 = 1*/
public class _4_202_HappyNumber {
    @Test
    public void test1() {
        System.out.println(isHappy(0));
    }

    public boolean isHappy(int n) {
        //用哈希表记录每次计算后的得到的数，如果有重复的，说明有了循环，不是快乐数
        Set<Integer> record = new HashSet<>();

        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        //跳出循环后判断n是否变为1，若是则是快乐数，否则不是
        return n == 1;
    }

    private int getNextNumber(int n) {
        //输入n，求n各位上的平方之和
        //如n=19, 输出1*1+9*9
        int result = 0;
        while (n > 0) {
            //先取末位上的数
            int temp = n % 10;
            result += temp * temp;
            //再取前一位的数
            n = n / 10;
        }

        return result;
    }
}
