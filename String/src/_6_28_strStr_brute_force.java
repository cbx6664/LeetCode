import org.junit.Test;

/**
 * ClassName: _6_28_strStr
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/28 16:56
 * @Version 1.0
 */
public class _6_28_strStr_brute_force {
    @Test
    public void test1() {
        System.out.println(strStr("hello", "ll"));
    }

    public int strStr(String haystack, String needle) {
        //暴力匹配
        int heyStackLength = haystack.length();
        int needleLength = needle.length();

        //i <= heyStackLength - needleLength是因为，text的指针i最大指到text.length - pattern.length，否则会index溢出
        for (int i = 0; i <= heyStackLength - needleLength; i++) {
            //pattern重新匹配，从头开始
            int j = 0;
            //i+j是因为：匹配上了字符后，text也要往后移动
            while (j < needleLength && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            //如果pattern都匹配上了，则返回pattern在text上开始的位置
            if (j == needleLength) {
                return i;
            }
        }
        return -1;
    }
}
