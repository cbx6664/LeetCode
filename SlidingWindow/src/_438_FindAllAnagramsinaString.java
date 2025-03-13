import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: _438_FindAllAnagramsinaString
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 8/12/24 15:28
 * @Version 1.0
 */
public class _438_FindAllAnagramsinaString {
    @Test
    public void test1() {
        findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int length = p.length();
        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);

        // 初始化构造一个长度为 p.length 的滑动窗口
        for (int i = length - 1; i < s.length(); i++) {
            char[] window = s.substring(start, i + 1).toCharArray();
            Arrays.sort(window);

            // 检测 window 是否是 p 的异位词
            if (Arrays.equals(window, pCharArray)) {
                list.add(start);
            }

            // 没找到，left 和 right 都++，滑动窗口整体右移
            start++;
        }

        return list;

    }
}
