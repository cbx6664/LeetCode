import org.junit.Test;

/**
 * ClassName: _2_242_ValidAnagram
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/24 11:23
 * @Version 1.0
 */
public class _2_242_ValidAnagram {
    @Test
    public void test1(){
        System.out.println(isAnagram("anagram", "aangram"));
    }
    public boolean isAnagram(String s, String t) {
        //哈希表存储26个字母表
        //数组就是一个简单的哈希表
        int[] record = new int[26];

        //将s中的每个字符出现的次数记录在record中
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        //将t中出现的每个字符的数量减去，如果最后record所有值都为0，则说明s和t中的字符是一样的
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        //只要record中有一个字母的出现数量不为0，则说明s和t中的字符不是完全一致
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }


}
