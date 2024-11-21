import org.junit.Test;

/**
 * ClassName: _21_617_MergeTwoBinaryTrees
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 20/11/24 15:33
 * @Version 1.0
 */
public class _21_617_MergeTwoBinaryTrees {

    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(new TreeNode(new TreeNode(5), 3, null), 1, new TreeNode(2));
        TreeNode node2 = new TreeNode(new TreeNode(null, 1, new TreeNode(4)), 2, new TreeNode(null, 3, new TreeNode(7)));

        System.out.println(_5_102_BinaryTreeLevelOrderTraversal.levelOrder(mergeTrees(node1, node2)));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
