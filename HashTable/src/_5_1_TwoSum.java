import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: _5_1_TwoSum
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/24 15:47
 * @Version 1.0
 */
/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9

所以返回 [0, 1]*/

public class _5_1_TwoSum {
    @Test
    public void test1() {
        System.out.println(twoSum(new int[]{3, 3}, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        //map存储nums数组中遍历过的元素, key是元素，value是元素在数组中的下标
        Map<Integer, Integer> map = new HashMap<>();

        //结果数组
        int[] result = new int[2];

        //遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            //如果map中存在一个值 与 当前的nums[i] 之和为target，则将其下标保存到结果数组
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            } else {//否则将nums数组的值添加到map中，为什么要后添加？因为要保证nums中的数只用一次
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
