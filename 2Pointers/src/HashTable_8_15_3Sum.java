import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: _8_15_3Sum
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/25 11:48
 * @Version 1.0
 */
/*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
请你找出所有满足条件且不重复的三元组。

注意： 答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]*/
public class HashTable_8_15_3Sum {
    @Test
    public void test1() {
        System.out.println(threeSum(new int[]{1, 0, -1, 0, -2, 2, 1, -1}));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        //先固定a，再寻找b,c
        //a=nums[i], b=nums[left], c=nums[right]

        //创建result结果动态数组
        List<List<Integer>> result = new ArrayList<>();

        //先把nums排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //已经从小到大排好序了，如果最小的a都>0则后面不用再看了
            if (nums[i] > 0) {
                return result;
            }

            //对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //找到了a+b+c = 0，开始对b和c去重，遇到重复的b和c直接跳过，避免再次被计入
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    right--;
                    left++;
                }
            }

        }
        return result;


    }
}
