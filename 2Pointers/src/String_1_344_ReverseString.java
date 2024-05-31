import org.junit.Test;

/**
 * ClassName: _1_344_ReverseString
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/27 21:43
 * @Version 1.0
 */
public class String_1_344_ReverseString {
    @Test
    public void test1() {
        reverseString(new char[]{'a', 'b', 'c', 'd', 'e'});
    }

    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;

        while (head < tail) {
            char temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            head++;
            tail--;
        }
    }
}
