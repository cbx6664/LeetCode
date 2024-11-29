import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _04_17_LetterCombinationsofaPhoneNumber
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 29/11/24 13:57
 * @Version 1.0
 */
public class _05_17_LetterCombinationsofaPhoneNumber {
    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    //    void backtracking(参数) {
//        if (终止条件) {
//            存放结果;
//            return;
//        }
//
//        for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
//            处理节点;
//            backtracking(路径，选择列表); // 递归
//            回溯，撤销处理结果
//        }
//    }


    void backTracking(String digits, int index, String[] numString) {
        // 终止条件
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        // 获取当前 digits 中 number 对应的 string
        // digits.charAt(index)得到的是'2'，是个字符，'2'-'0'=2
        String str = numString[digits.charAt(index) - '0'];

        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            backTracking(digits, index + 1, numString);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }


    }

    public List<String> letterCombinations(String digits) {
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTracking(digits, 0, numString);

        return result;

    }

    @Test
    public void test1() {
        letterCombinations("23");
    }
}
