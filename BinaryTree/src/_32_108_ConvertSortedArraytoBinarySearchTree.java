import java.util.Arrays;

/**
 * ClassName: _32_108_ConvertSortedArraytoBinarySearchTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 24/11/24 22:18
 * @Version 1.0
 */
public class _32_108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 终止条件
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        // 单次递归逻辑
        int rootIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        int[] leftNums = Arrays.copyOfRange(nums, 0, rootIndex);
        int[] rightNums = Arrays.copyOfRange(nums, rootIndex + 1, nums.length);

        // 递归左右子树
        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);

        return root;

    }
}
