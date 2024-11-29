import org.junit.Test;

/**
 * ClassName: _33_538_ConvertBSTtoGreaterTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 25/11/24 12:03
 * @Version 1.0
 */
public class _33_538_ConvertBSTtoGreaterTree {
    TreeNode pre = null;

    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(0), 1, new TreeNode(null, 2, new TreeNode(3))), 4, new TreeNode(new TreeNode(5), 6, new TreeNode(null, 7, new TreeNode(8))));
        convertBST(node);
    }

    public TreeNode convertBST(TreeNode cur) {
        // 终止条件
        if (cur == null) {
            return null;
        }

        // 右
        cur.right = convertBST(cur.right);

        // 中（当前节点）
        if (pre != null) {
            cur.val += pre.val;
        }

        // 处理完 val 再更新pre
        pre = cur;

        // 左
        cur.left = convertBST(cur.left);

        return cur;

    }
}
