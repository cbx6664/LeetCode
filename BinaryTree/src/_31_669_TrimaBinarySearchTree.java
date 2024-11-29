import org.junit.Test;

/**
 * ClassName: _31_669_TrimaBinarySearchTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 24/11/24 12:13
 * @Version 1.0
 */
public class _31_669_TrimaBinarySearchTree {
    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(null, 0, new TreeNode(new TreeNode(1), 2, null)), 3, new TreeNode(4));
        trimBST(node, 1, 3);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 终止条件
        if (root == null) {
            return null;
        }

        // 单次遍历的操作
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
