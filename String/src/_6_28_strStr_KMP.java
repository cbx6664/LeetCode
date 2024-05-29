import org.junit.Test;

/**
 * ClassName: _6_28_strStr
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/28 16:56
 * @Version 1.0
 */
public class _6_28_strStr_KMP {
    @Test
    public void test1() {
        System.out.println(strStr("ABABDABACDABABCABAB", "ABABCABAB"));
    }

    public int strStr(String haystack, String needle) {
        //haystack的指针
        int i = 0;
        //needle的指针
        int j = 0;

        int[] lps = LPS(needle);

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == needle.length()) {
                return i - needle.length();
            }
        }
        return -1;

    }

    private int[] LPS(String pattern) {
        char[] patternCh = pattern.toCharArray();

        int[] lps = new int[pattern.length()];

        int prevLPS = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (patternCh[i] == patternCh[prevLPS]) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else if (prevLPS == 0) {
                lps[i] = 0;
                i++;
            } else prevLPS = lps[prevLPS - 1];

        }
        return lps;

    }
}
