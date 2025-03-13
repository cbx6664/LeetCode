import org.junit.Test;

import java.util.HashSet;

/**
 * ClassName: _128_LongestConsecutiveSequence
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 5/12/24 10:59
 * @Version 1.0
 */
public class _128_LongestConsecutiveSequence {
    @Test
    public void test1() {
        System.out.println(longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
    }

    public int longestConsecutive(int[] nums) {
        int result = 0;
        if (nums.length == 0) {
            return 0;
        }
        // 将 nums 放入 hashSet
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int x : set) {
            // 如果 set 中有 x-1，说明当前以 x 开头的序列不可能是最长的，直接跳过就好，节省运算时间
            if (set.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            // 找到 j+1 的元素
            while (set.contains(y)) {
                y++;
            }
            result = Math.max(result, y - x);
        }

        return result;
    }
}
