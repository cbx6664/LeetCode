import org.junit.Test;

/**
 * ClassName: _2_704_BinarySearch
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/22 9:51
 * @Version 1.0
 */
public class _2_704_BinarySearch {
    /*
     * 二分法查找
     * 前提:
     * 1.有序数组
     * 2.无重复元素
     * */

    @Test
    public void test1() {
        System.out.println(searchInclusive(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    public void test2(){
        System.out.println(searchExclusive(new int[]{1, 2, 3, 4, 5}, 1));
    }


    //target ∈ [left, right], 只要定义了区间, 就要坚持左闭右闭, 循环不变量原则
    public int searchInclusive(int[] nums, int target) {

        if (target < nums[0] || target > nums[nums.length - 1]) {  //不在区间范围的target直接返回-1
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] > target) {  //middle值在target右侧, 将搜索右区间设置为middle-1
                right = middle - 1;
            } else if (nums[middle] < target) {  //middle值在target的左侧, 将搜索左区间设置为middle+1
                left = middle + 1;
            } else if (nums[middle] == target) {  //middle值等于target, 返回index
                return middle;
            }
        }
        return -1;
    }

    //target ∈ [left, right), 同理, 定义了区间, 就要坚持左闭右开
    public int searchExclusive(int[] nums, int target) {

        if (target < nums[0] || target > nums[nums.length - 1]) {  //不在区间范围的target直接返回-1
            return -1;
        }

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = (left + right) / 2;

            if (nums[middle] > target) {  //middle值在target右侧, 将搜索右区间设置为middle
                right = middle;
            } else if (nums[middle] < target) {  //middle值在target的左侧, 将搜索左区间设置为middle+1
                left = middle + 1;
            } else if (nums[middle] == target) {  //middle值等于target, 返回index
                return middle;
            }
        }
        return -1;
    }

}
