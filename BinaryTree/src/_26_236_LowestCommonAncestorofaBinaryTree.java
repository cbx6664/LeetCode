import org.junit.Test;

/**
 * ClassName: _26_236_LowestCommonAncestorofaBinaryTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 23/11/24 11:48
 * @Version 1.0
 */
public class _26_236_LowestCommonAncestorofaBinaryTree {
    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(6), 5, new TreeNode(new TreeNode(7), 2, new TreeNode(4))), 3, new TreeNode(new TreeNode(0), 1, new TreeNode(8)));
        lowestCommonAncestor(node, new TreeNode(5), new TreeNode(1));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 需要自下而上的遍历，如果子树包含了p、q，则找到了最小公共祖先
        // 终止条件，节点为空 或 节点=p 或 节点=q
        if (root == null || root == q || root == p) {
            return root;
        }

        // 左
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 右
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 中
        //左右子树都不为空，意味着 此时的root就是lca
        //左子树返回空，右子树不返回null，意味着 右子树是 lca
        //左子树不为空，右子树返回 null，意味着 左子树就是lca
        // 全为 null，说明没有 lca
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }

    }
}
