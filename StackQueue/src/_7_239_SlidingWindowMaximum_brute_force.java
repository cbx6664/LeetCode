import org.junit.Test;

/**
 * ClassName: _7_239_SlidingWindowMaximum
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/3 15:52
 * @Version 1.0
 */
public class _7_239_SlidingWindowMaximum_brute_force {
    @Test
    public void test1() {
        System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int numsLength = nums.length;

        for (int i = 0; i <= numsLength - k; i++) {//最大值数组的长度是nums.length - k + 1
            int max = nums[i];
            for (int j = 1; j < k; j++) {//滑动窗口的大小是k
                if (nums[i + j] > max) {
                    max = nums[i + j];
                }
            }
            result[i] = max;
        }

        return result;
    }
}
