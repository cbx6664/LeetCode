import org.junit.Test;

import java.util.Stack;

/**
 * ClassName: _4_20_ValidParentheses
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/2 14:59
 * @Version 1.0
 */
public class _4_20_ValidParentheses {
    @Test
    public void test1(){
        System.out.println(isValid("({[)))"));
    }
    public boolean isValid(String s) {
        //s的长度必须是偶数才有可能有效匹配
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //遇到左括号，把对应的右括号压入栈
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
                //若栈空了 或者 当前元素对应不上栈顶元素，则匹配失败
            } else if (stack.empty() || s.charAt(i) != stack.peek()) {
                return false;
            } else {//如果是右括号，则弹出
                stack.pop();
            }
        }

        return stack.empty();
    }
}
