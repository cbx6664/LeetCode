import org.junit.Test;

/**
 * ClassName: _42_TrappingRainWater
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 7/12/24 20:32
 * @Version 1.0
 */
public class _42_TrappingRainWater {
    @Test
    public void test1() {
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));

    }

    //接水量源于「左右最高壁垒的最低值」与「当前高度」的差值。
    //最高柱子将数组分为两部分，使你在各自部分只需从一侧开始维护最大值，简化了寻找「左右最高壁垒」的过程。
    public int trap(int[] height) {
        int result = 0;
        int peak_height = Integer.MIN_VALUE;
        int peak_index = 0;
        int left_max = Integer.MIN_VALUE;
        int right_max = Integer.MIN_VALUE;

        // 一个格子一个格子的计算
        // 首先找到最高的挡板，以它为界，左右分别计算单独格子中的雨水
        for (int i = 0; i < height.length; i++) {
            if (height[i] > peak_height) {
                peak_height = height[i];
                peak_index = i;
            }
        }

        // 遍历最高挡板的左边，维护一个 left_max 左边的最高挡板作为容器的左边界，
        // height[i] > left_max 则更新，height[i] < left_max 则装水
        for (int i = 0; i < peak_index; i++) {
            if (height[i] >= left_max) {
                left_max = height[i];
            } else {
                result += left_max - height[i];
            }
        }

        // 右边同理
        for (int i = height.length - 1; i > peak_index; i--) {
            if (height[i] >= right_max) {
                right_max = height[i];
            } else {
                result += right_max - height[i];
            }
        }


        return result;
    }
}
