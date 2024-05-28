import org.junit.Test;

/**
 * ClassName: _5_RightRotateString
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/28 16:10
 * @Version 1.0
 */
public class _5_RightRotateString {
    @Test
    public void test1(){
        System.out.println(rightRotate("abcdefg", 2));
    }
    public StringBuilder rightRotate(String s, int k) {
        //新建一个字符串保存结果
        StringBuilder sb = new StringBuilder();
        //rightStart记录开始右旋的字符index
        int rightStart = s.length() - k;

        //start记录非右旋部分的首个字符
        int start = 0;
        //end记录非右旋的末尾字符
        int end = rightStart - 1;

        while (rightStart < s.length()) {
            sb.append(s.charAt(rightStart));
            rightStart++;
        }

        while (start <= end) {
            sb.append(s.charAt(start));
            start++;
        }
        return sb;

    }

}
