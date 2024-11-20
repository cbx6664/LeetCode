import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _17_113_PathSumII
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 14/11/24 15:07
 * @Version 1.0
 */
public class _17_113_PathSumII {
    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 11, new TreeNode(2)), 4, null), 5, new TreeNode(new TreeNode(13), 8, new TreeNode(new TreeNode(5), 4, new TreeNode(1))));
        System.out.println(pathSum(node, 22));

    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> nodeList = new ArrayList<>();

    public void traversal(TreeNode root, int targetSum) {
        // 使用递归
        // 1. 参数：根节点，targetSum；返回值：无需返回值，因为要遍历全部二叉树

        // 3. 单层递归逻辑：
        nodeList.add(root.val);
        // 隐式回溯
        targetSum -= root.val;

        // 2. 终止条件要在每次递归操作完之后再执行：是叶子节点 && targetSum 被路径上的 val 减为 0
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(nodeList));
        }

        if (root.left != null) {
            traversal(root.left, targetSum);
        }

        if (root.right != null) {
            traversal(root.right, targetSum);
        }

        // 回溯，因为走到这一步说明没有找到合适的路径，所以撤销上一步的改变，不要影响下一步的递归
        nodeList.removeLast();

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null) {
            traversal(root, targetSum);
        }

        return result;
    }

}
