import org.junit.Test;

/**
 * ClassName: _4_151_ReverseWordsinaString
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/28 13:19
 * @Version 1.0
 */
/*给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：
输入: "the sky is blue"
输出: "blue is sky the"

示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个*/

//可以拆解为：
//1.去除首尾、中间多余的空格
//2.反转整个字符串
//3.反转每个单词
public class String_4_151_ReverseWordsinaString {
    @Test
    public void test1() {
        System.out.println(reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        s = removeSpace(s);
        s = reverseString(s, 0, s.length() - 1);
        s = reverseWord(s);
        return s;
    }

    public String removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        //用start指向字符串第一个字符
        while (s.charAt(start) == ' ') start++;
        //用end指向字符串最后一个字符
        while (s.charAt(end) == ' ') end--;

        //新建字符串
        StringBuffer stringBuffer = new StringBuffer();

        while (start <= end) {
            //只要start指向的字符不是空格 或者 新字符串的当前字符不是空格 就继续添加字符，保证了两个字符间只有一个空格
            if (s.charAt(start) != ' ' || stringBuffer.charAt(stringBuffer.length() - 1) != ' ') {
                stringBuffer.append(s.charAt(start));
            }
            //更新start指针
            start++;
        }
        return stringBuffer.toString();
    }

    private String reverseString(String s, int start, int end) {
        char[] ch = s.toCharArray();
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }

    public String reverseWord(String s) {
        int slow = 0;
        int fast = 0;
        while (fast < s.length()) {
            //别把s.charAt(fast) != ' ' 放前面判断，
            // 因为fast必须指向s.length()才能完整的reverse，但是这样的话调用s.charAt(fast)就会超出范围
            //需要把s.charAt(fast) != ' ' 放后面判断
            //这样的话第一个条件不满足就直接跳过了，不用执行后面的超出index范围的代码
            while (fast < s.length() && s.charAt(fast) != ' ') fast++;
            s = reverseString(s, slow, fast - 1);
            //更新slow，fast
            fast++;
            slow = fast;
        }

        return s;
    }
}
