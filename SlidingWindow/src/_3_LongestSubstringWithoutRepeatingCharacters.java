import org.junit.Test;

import java.util.HashMap;

/**
 * ClassName: _3_LongestSubstringWithoutRepeatingCharacters
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 8/12/24 13:48
 * @Version 1.0
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    @Test
    public void test1() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }

    public int lengthOfLongestSubstring(String s) {
        int result = 1;
        if (s.length() == 0) {
            return 0;
        }

        // 左指针
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        // 右指针
        for (int i = 0; i < s.length(); i++) {
            // 将当前访问的元素 frequency+1
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            // 查重，当前访问的元素 和 滑动窗口内的元素是否重复
            while (map.get(s.charAt(i)) > 1) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }

            // 每次更新完滑动窗口，都要更新 result
            result = Math.max(result, i - start + 1);
        }
        return result;
    }

    // 每次比较 下一个元素和窗口内元素 都使用了循环，可以使用 hashmap 优化
    public int lengthOfLongestSubstringOld(String s) {
        int result = 1;
        if (s.length() == 0) {
            return 0;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;

        while (right < charArray.length - 1) {
            // right+1指向的元素和当前滑动窗口内的元素不重复，扩大滑动窗口，right++
            while (right + 1 <= charArray.length - 1 && !isRepeated(s.substring(left, right + 1), charArray[right + 1])) {
                right++;
                result = Math.max(result, right - left + 1);
            }
            while (right + 1 <= charArray.length - 1 && isRepeated(s.substring(left, right + 1), charArray[right + 1])) {
                // right+1 指向的元素和当前滑动窗口内的元素重复了，更改当前滑动窗口的范围，left+1
                left++;
            }

        }
        return result;
    }

    public boolean isRepeated(String s, char c) {
        char[] charArray = s.toCharArray();
        for (char c1 : charArray) {
            if (c1 == c) {
                return true;
            }
        }
        return false;
    }

}
