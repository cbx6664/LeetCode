import org.junit.Test;

import java.util.HashMap;

/**
 * ClassName: _560_SubarraySumEqualsK
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 9/12/24 12:19
 * @Version 1.0
 */
/*
因为nums[]非单调，滑动窗口不能有效工作，使用前缀和优化更好
*/
public class _560_SubarraySumEqualsK {
    @Test
    public void test1() {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));

    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // 前缀和 map
        HashMap<Integer, Integer> map = new HashMap<>();
        // 本来就自带的前缀 0
        map.put(0, 1);
        int sum = 0;

        // 遍历 nums
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 寻找有没有 prefix 使得 sum - prefix == k，即 prefix = sum - k
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            // 遍历时 顺便记录前缀和 map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
