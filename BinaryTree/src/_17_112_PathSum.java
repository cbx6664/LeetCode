import org.junit.Test;

/**
 * ClassName: _17_112_PathSum
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 14/11/24 13:03
 * @Version 1.0
 */
public class _17_112_PathSum {
    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 11, new TreeNode(2)), 4, null), 5, new TreeNode(new TreeNode(13), 8, new TreeNode(null, 4, new TreeNode(1))));
        System.out.println(hasPathSum(node, 22));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 使用递归
        // 1. 参数：根节点，targetSum；返回值：是否包含 targetSum

        // 2. 终止条件：是叶子节点 && targetSum 被路径上的 val 减为 0
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        // 3. 单层递归逻辑：如果递归函数返回 true，应该立刻返回 true
        targetSum -= root.val;

        if (root.left != null) {
            if (hasPathSum(root.left, targetSum)) {
                return true;
            }
        }

        if (root.right != null) {
            if (hasPathSum(root.right, targetSum)) {
                return true;
            }
        }

        return false;

    }

//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        // 如果根节点为空，直接返回 false
//        if (root == null) {
//            return false;
//        }
//
//        // 终止条件：当前节点是叶子节点且路径和等于目标和
//        if (root.left == null && root.right == null) {
//            return targetSum == root.val;
//        }
//
//        // 单层递归逻辑：检查左子树和右子树
//        targetSum -= root.val;
//        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
//    }
}
