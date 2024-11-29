import org.junit.Test;

/**
 * ClassName: _29_701_InsertintoaBinarySearchTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 23/11/24 14:46
 * @Version 1.0
 */
public class _29_701_InsertintoaBinarySearchTree {
    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(1), 2, new TreeNode(3)), 4, new TreeNode(7));
        insertIntoBST(node, 5);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 终止条件
        // 遇到空节点，插入新节点
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }

        // 当前 root.val 和 val比较, val更大的话要插到 root 的右子树中
        if (val > root.val) {
            // 将新节点和 root 联系起来
            root.right = insertIntoBST(root.right, val);
        }

        if (val < root.val) {
            // 将新节点和 root 联系起来
            root.left = insertIntoBST(root.left, val);
        }

        return root;

    }
}
