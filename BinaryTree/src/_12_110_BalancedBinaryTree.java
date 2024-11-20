import org.junit.Test;

/**
 * ClassName: _12_110_BalancedBinaryTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/8/11 16:58
 * @Version 1.0
 * @Thought 分别求左右子树的depth，然后做绝对值的差，判断是否平衡
 */
public class _12_110_BalancedBinaryTree {
    @Test
    public void test1() {
        int height = getHeight(new TreeNode(new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 5, null), 4, new TreeNode(6)), 2, null), 1, new TreeNode(3)));
        System.out.println(height);

    }

    // 辅助函数：计算节点的高度，并检查子树是否平衡
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子树的高度
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // 如果左右子树高度差大于1，返回-1表示不平衡
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // 返回节点的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;

    }

}
