package _3_house_rubber;

import org.junit.Test;

/**
 * ClassName: AnotherHouseRobberII213
 * Package: week7
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/4 17:22
 * @Version 1.0
 */
public class _30_213AnotherHouseRobberII {
    @Test
    public void test1(){
        System.out.println(rob(new int[]{1,2,3,1}));
    }
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }
}
