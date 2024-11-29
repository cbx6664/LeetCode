import org.junit.Test;

/**
 * ClassName: _28_235_LowestCommonAncestorofaBinarySearchTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 23/11/24 14:09
 * @Version 1.0
 */
public class _28_235_LowestCommonAncestorofaBinarySearchTree {
    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(0), 2, new TreeNode(new TreeNode(3), 4, new TreeNode(5))), 6, new TreeNode(new TreeNode(7), 8, new TreeNode(9)));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // bst 是有序，所以[p, q]或者[q,p]区间内，自上向下遍历的第一个 root 就是lca
        //终止条件
        if (root == null) {
            return null;
        }

        // 遍历顺序无所谓了
        // 如果 root 的 val 比 p和q 的值都大，说明 lca 在左子树，当前的 root 在他们的右边
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }

        // 如果 root 的 val 比 p和q 的值都小，说明 lca 在右子树，当前的 root 在他们的左边
        if (root.val < p.val && root.val < q.val) {
            TreeNode right= lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }

        // 剩下的情况就是 root 在 p,q 的范围内（p,q的相对大小不清楚），直接返回 root
        return root;
    }


}
