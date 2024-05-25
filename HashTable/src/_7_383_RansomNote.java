import org.junit.Test;

/**
 * ClassName: _7_383_RansomNote
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/25 11:35
 * @Version 1.0
 */
/*
 * 判断ransomNote是否可以由magazine中的元素构成，且magazine中的每个元素只能用一次，而且都是小写字母
 * */
public class _7_383_RansomNote {
    @Test
    public void test1(){
        System.out.println(canConstruct("aa", "aab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        //如果ransomNote的长度大于magazine，直接返回false，因为不可能由magazine构成ransomNote
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        //因为规定了都用小写字母，所以使用数组更节省空间
        int[] record = new int[26];
        //将magazine中的每个字符保存在record中，数组的值就是对应字母出现的次数
        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }

        //遍历ransomNote中的字符，减去其record中出现的次数
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']--;
        }

        for (int i : record) {
            //如果record中出现负值，说明ransomNote中存在magazine中没有的字符
            if (i < 0) {
                return false;
            }
        }

        return true;
    }
}
