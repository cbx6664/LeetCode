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
/*
示例 1：

输入: ["2", "1", "+", "3", " * "]
输出: 9
解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
* */
public class _6_150_EvaluateReversePolishNotation {
    @Test
    public void test1() {
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            //遍历s，将元素压入栈
            //如果当前遍历的字符串是运算符号，则运算，并将结果压入栈
            if (tokens[i].equals( "+")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b + a));
            } else if (tokens[i].equals("-")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b - a));
            } else if (tokens[i].equals("*")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b * a));
            } else if (tokens[i].equals("/")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b / a));
            } else {//是数字的话就压入栈
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }

}
