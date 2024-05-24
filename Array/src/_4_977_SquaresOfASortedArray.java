import org.junit.Test;

/**
 * ClassName: _4_977_SquaresofaSortedArray
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/22 11:40
 * @Version 1.0
 */

/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
        示例 1：

        输入：nums = [-4,-1,0,3,10]
        输出：[0,1,9,16,100]
        解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
        */

public class _4_977_SquaresOfASortedArray {
    @Test
    public void test1(){
        System.out.println(sortedSquares(new int[]{-4, -1, 0, 3, 10}));
    }
    
    public int[] sortedSquares(int[] nums) {
        //数组是有序的, 因此平方后最大的值只能出现在数组两侧, 不会出现在数组中间.

        //k指向result数组的末尾, 因为要将平方后的值从大到小插入, 所以需要从后往前插入
        int k = nums.length - 1;
        int[] result = new int[nums.length];

        //双指针, i指向数组左侧, j指向数组右侧
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k--] = nums[i] * nums[i];
                i++;
            } else {
                result[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }

}
