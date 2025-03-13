import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: _49_GroupAnagrams
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 4/12/24 16:27
 * @Version 1.0
 */
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//Explanation:
//
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

public class _49_GroupAnagrams {
    @Test
    public void test1() {
        groupAnagrams(new String[]{"", "", "B"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // 使用 map 存放单词 和其对应的排序后的字母，如eat -> aet, ate -> aet，因为只有重新排序后的字母相同，才能被归为一个组
        HashMap<String, List<String>> map = new HashMap<>();
        // 把 strs 中的字符串都转换成 char[]，为了排序字母
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            // 检查 key 是否存在,若不存在就新建 value
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            // 将排序后相同的单词加入同一组
            map.get(sortedString).add(s);
        }

        return new ArrayList<>(map.values());
    }

}
