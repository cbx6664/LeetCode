import org.junit.Test;

/**
 * ClassName: _7_459_RepeatedSubstringPattern_brute_force
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/30 12:38
 * @Version 1.0
 */
public class _7_459_RepeatedSubstringPattern_brute_force {
    @Test
    public void test1(){
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        //重复子串最长也不会超过母串的一半，因为要重复
        //i代表字串的长度
        for (int i = 1; i * 2 <= n; ++i) {
            //检查字串的长度能否整除字符串长度，即母串长度能否由字串长度重复构成
            if (n % i == 0) {
                //若能，则检查母串是否为子串重复构成的
                boolean match = true;
                //从索引i开始遍历母串
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;

    }
}
