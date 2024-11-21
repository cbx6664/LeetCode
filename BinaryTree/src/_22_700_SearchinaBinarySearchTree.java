import org.junit.Test;

/**
 * ClassName: _22_700_SearchinaBinarySearchTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 20/11/24 15:42
 * @Version 1.0
 */
public class _22_700_SearchinaBinarySearchTree {
    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(1), 2, new TreeNode(3)), 4, new TreeNode(7));
        System.out.println(_5_102_BinaryTreeLevelOrderTraversal.levelOrder(searchBST(node, 3)));

    }

    public TreeNode searchBST(TreeNode root, int val) {
        // 2. 终止条件
        if (root == null || val == root.val) {
            return root;
        }

        // 3. 单次递归逻辑
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        return searchBST(root.right, val);
    }

}
