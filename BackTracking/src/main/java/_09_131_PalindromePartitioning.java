import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _09_131_PalindromePartitioning
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 30/11/24 20:01
 * @Version 1.0
 */
public class _09_131_PalindromePartitioning {
    @Test
    public void test1() {
        partition("aab");
    }

    List<String> path = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;
    }

    boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    void backTracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String string = s.substring(startIndex, i + 1);
                path.add(string);
            } else {
                continue;
            }
            backTracking(s, i + 1);
            path.removeLast();
        }

    }
}
