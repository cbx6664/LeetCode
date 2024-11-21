import org.junit.Test;

/**
 * ClassName: _23_98_ValidateBinarySearchTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 20/11/24 16:13
 * @Version 1.0
 */
public class _23_98_ValidateBinarySearchTree {
    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(1), 5, new TreeNode(new TreeNode(3), 4, new TreeNode(6)));
        System.out.println(isValidBST(node));
    }

    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        // 2. 终止条件
        // 当前节点为 null，说明递归到到了叶子节点的子节点，返回 true
        if (root == null) {
            return true;
        }

        // 3. 单层递归逻辑
        // 检查左子树，如果不满足 bst 则返回 false
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        // 检查 root，如果 val 比上次递归的 root 大，则返回 false
        if (max != null && max.val >= root.val) {
            return false;
        }
        max = root;
        // 检查右子树
        boolean right = isValidBST(root.right);
        return right;

    }
}
