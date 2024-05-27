import org.junit.Test;

/**
 * ClassName: _2_541_ReverseStringII
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/27 21:53
 * @Version 1.0
 */

/*Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them.
If there are less than 2k but greater than or equal to k characters,
then reverse the first k characters and leave the other as original.*/
public class _2_541_ReverseStringII {
    @Test
    public void test1() {
        System.out.println(reverseStr("abcdefg", 2));

    }

    public String reverseStr(String s, int k) {
        char[] stringArray = s.toCharArray();

        //每隔2k个字符的前k个字符反转
        for (int i = 0; i < stringArray.length; i += 2 * k) {

            //如果剩余的字符数小于2k，大于k，则反转前k个字符
            if (stringArray.length - i < 2 * k && stringArray.length - i > k) {
                reverse(stringArray, i, i + k - 1);
                continue;
            }

            //如果剩余的字符数小于k，则全部反转
            if (stringArray.length - i < k) {
                reverse(stringArray, i, stringArray.length - 1);
                continue;
            }

            reverse(stringArray, i, i + k - 1);

        }
        return new String(stringArray);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }


}
