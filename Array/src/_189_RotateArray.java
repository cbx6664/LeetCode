import org.junit.Test;

/**
 * ClassName: _189_RotateArray
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 13/12/24 14:22
 * @Version 1.0
 */
public class _189_RotateArray {
    @Test
    public void test1() {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(3 % 7);
    }

    public void rotate(int[] nums, int k) {
        int num = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, num - 1);
        swap(nums, num, nums.length - 1);

    }

    public void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
