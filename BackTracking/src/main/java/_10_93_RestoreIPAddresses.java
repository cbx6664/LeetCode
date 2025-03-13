import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _10_93_RestoreIPAddresses
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2/12/24 11:19
 * @Version 1.0
 */
public class _10_93_RestoreIPAddresses {
    @Test
    public void test1() {
        List<String> result = restoreIpAddresses("0279245587303");
        for (String ip : result) {
            System.out.println(ip);
        }
    }

    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        stringBuilder.append(s);
        backTracking(s, 0, 0);
        return result;
    }

    // 注意 string builder 和 s 的 index 区别，stringbuiler 的 index-dotsNumber == s 的 index
    void backTracking(String s, int dotsNumber, int startIndex) {
        // 终止条件
        if (dotsNumber == 3) {
            if (isValid(s, startIndex - dotsNumber, s.length() - 1)) {
                result.add(stringBuilder.toString());
            }
            return;
        }

        if (dotsNumber > 3) {
            return;
        }

        for (int i = startIndex; i < stringBuilder.length(); i++) {
            if (isValid(s, startIndex - dotsNumber, i - dotsNumber)) {
                stringBuilder.insert(i + 1, '.');
                dotsNumber++;
                // 加了dot，index 需要多加一个
                backTracking(s, dotsNumber, i + 2);
                dotsNumber--;
                stringBuilder.deleteCharAt(i + 1);
            } else
                break;


        }
    }

    // 区间规定为：左闭右闭
    boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }

        // 0开头不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }

        // 不能大于 255
        if (end - start > 3) {
            return false;
        }

        if (Integer.parseInt(s.substring(start, end + 1)) > 255) {
            return false;
        }

        return true;
    }
}