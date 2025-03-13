import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * ClassName: _15_3Sum
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 6/12/24 16:23
 * @Version 1.0
 */
public class _15_3Sum {
    @Test
    public void test1() {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    private final Logger logger = Logger.getLogger(this.getClass().getName());


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);


        // 先固定a，再找b,c
        for (int i = 0; i < nums.length - 2; i++) {
            // 优化，如果最小的值已经大于 0 了，肯定没有答案的
            if (nums[i] > 0) {
                break;
            }

            // 去重 a，当前 a 和之前的 a 值一样，直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) { // 去重 a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    path.add(nums[i]);
                    path.add(nums[left]);
                    path.add(nums[right]);
                    result.add(new ArrayList<>(path));
                    path.clear();

                    // 去重 b，如果现在的 b 和未来的 b 的值一样，跳过一次
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // 去重 c，如果现在的 c 和未来的 c 的值一样，跳过一次
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    /* 同时修改 left 和 right 避免重复，因为如果 left 和 right 代表的 b,c 大小不变，肯定是重复的情况，
                     只改 b 或只改 c 看起来可以，但是 a 没变，b、c 只改其中一个，那最终满足 a+b+c=0的还是重复的 b 或 c
                     所以要同时修改 b 和 c*/
                    left++;
                    right--;
                }

                // 通过 sum 来调整 两个指针的关系
                if (sum < 0) {
                    left++;
                }
                if (sum > 0) {
                    right--;
                }
            }
        }


        return result;
    }

}
