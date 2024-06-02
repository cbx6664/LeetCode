import org.junit.Test;

import java.util.Stack;

/**
 * ClassName: _5_1047_RemoveAllAdjacentDuplicatesInString
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/2 15:47
 * @Version 1.0
 */
/*匹配问题都是栈的强项
* 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

示例：

输入："abbaca"
输出："ca"
解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
* */
public class _5_1047_RemoveAllAdjacentDuplicatesInString {
    @Test
    public void test1() {
        System.out.println(removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //遍历s，将元素压入栈
            //如果当前遍历的字符和栈中已经压入的上一个相邻的字符相同，即重复相邻字符，删除栈中的那个字符
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.empty())
            stringBuilder.append(stack.pop());

        return stringBuilder.reverse().toString();
    }

}
