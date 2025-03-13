import org.junit.Test;

/**
 * ClassName: _11_ContainerWithMostWater
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 5/12/24 15:27
 * @Version 1.0
 */
public class _11_ContainerWithMostWater {
    @Test
    public void test1() {
        maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    public int maxArea(int[] height) {
        int area = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
            // 如果左边比右边短，更换左边界
            if (height[left] < height[right]) {
                left += 1;
            } else {
                // 左边界不比右边短，更换有边界
                right -= 1;
            }
        }
        return area;
    }
}
