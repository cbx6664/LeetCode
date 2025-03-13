import org.junit.Test;

/**
 * ClassName: _283_MoveZeroes
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 5/12/24 14:37
 * @Version 1.0
 */
public class _283_MoveZeroes {

    @Test
    public void test1() {
        moveZeroes(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        // 指向 0 的指针
        int i0 = 0;
        // 指向非 0 的指针
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i0];
                nums[i0] = nums[i];
                nums[i] = temp;
                // 更新指向 0 的指针
                i0++;
            }
        }
    }
}
