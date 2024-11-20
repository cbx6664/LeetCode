import org.junit.Test;

import java.util.*;

/**
 * ClassName: _19_654_MaximumBinaryTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 19/11/24 23:07
 * @Version 1.0
 */
public class _19_654_MaximumBinaryTree {
    @Test
    public void test1() {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        System.out.println(levelOrder(constructMaximumBinaryTree(nums)));


    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 终止条件
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        // 单次递归逻辑
        int rootIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(max);


        int[] leftNums = Arrays.copyOfRange(nums, 0, rootIndex);
        int[] rightNums = Arrays.copyOfRange(nums, rootIndex + 1, nums.length);
        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);

        return root;
    }

    public TreeNode traversal(int[] nums) {

        return null;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            //每一层用一个list存放value
            List<Integer> eachLevel = new ArrayList<>();
            //记录每一层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //记录当前层节点的value
                eachLevel.add(node.val);
                //下一层的节点加入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //把每一层的value list 存入result
            result.add(eachLevel);
        }
        return result;
    }
}
