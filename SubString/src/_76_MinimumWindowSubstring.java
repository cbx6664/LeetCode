import org.junit.Test;

import java.util.HashMap;

/**
 * ClassName: _76_MinimumWindowSubstring
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 10/12/24 21:03
 * @Version 1.0
 */
public class _76_MinimumWindowSubstring {
    @Test
    public void test1() {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }

    HashMap<Character, Integer> smap = new HashMap();
    HashMap<Character, Integer> tmap = new HashMap();

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int left = 0;
        int right;
        String result = "";

        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);

        }
        for (right = 0; right < s.length(); right++) {
            // 更新窗口内包含的字符
            smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right), 0) + 1);

            // 如果集齐了 t 中的所有字母，先记录当前子串，再收缩窗口继续寻找更小的窗口
            while (contains(t)) {

                // 如果此时 result 更短，则更新 result
                result = s.substring(left, right + 1);
                smap.put(s.charAt(left), smap.get(s.charAt(left)) - 1);
                left++;
            }


        }

        return result;

    }

    public boolean contains(String t) {
        for (int i = 0; i < t.length(); i++) {
            if (smap.getOrDefault(t.charAt(i), 0) < tmap.get(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
