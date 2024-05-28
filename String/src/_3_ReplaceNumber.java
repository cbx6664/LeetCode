import org.junit.Test;

/**
 * ClassName: _3_ReplaceNumber
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/28 10:45
 * @Version 1.0
 */
/*给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。

例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。

对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"*/
public class _3_ReplaceNumber {
    @Test
    public void test1() {
        System.out.println(replaceNumber("a1b2c"));
    }

    public String replaceNumber(String s) {
        //统计数字的个数
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        //记录原字符的长度
        int oldLength = s.length();
        int oldIndex = oldLength - 1;
        //创建新的字符数组
        char[] newChar = new char[oldLength + count * 5];
        //记录新的字符长度
        int newLength = newChar.length;
        int newIndex = newLength - 1;
        //从后向前填充，因为从前向后每次都要讲添加元素之后的所有元素向后移动
        while (oldIndex >= 0) {
            //若有数字，替换成'number'
            if (s.charAt(oldIndex) >= '0' && s.charAt(oldIndex) <= '9') {
                newChar[newIndex--] = 'r';
                newChar[newIndex--] = 'e';
                newChar[newIndex--] = 'b';
                newChar[newIndex--] = 'm';
                newChar[newIndex--] = 'u';
                newChar[newIndex--] = 'n';
            } else {
                newChar[newIndex--] = s.charAt(oldIndex);
            }

            oldIndex--;

        }
        return new String(newChar);
    }
}
