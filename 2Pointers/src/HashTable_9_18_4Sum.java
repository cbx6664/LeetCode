import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: _9_18_4Sum
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/25 18:34
 * @Version 1.0
 */

/*
 * 三数之和的进阶，target自定，同样不能有重复的四元组*/
public class HashTable_9_18_4Sum {
    @Test
    public void test1() {
        System.out.println(fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //先固定a和b，再寻找c,d
        //a=nums[i], b=nums[j], c=nums[left], d=nums[right]

        //创建result结果动态数组
        List<List<Integer>> result = new ArrayList<>();

        //先把nums排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //已经从小到大排好序了，如果最小的a都>0且>target则后面不用再看了，因为后面越加越大
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            //对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                //对b去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        //对c和d去重
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
        }
        return result;
    }

}
