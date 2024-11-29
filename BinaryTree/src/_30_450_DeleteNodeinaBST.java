/**
 * ClassName: _30_450_DeleteNodeinaBST
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 23/11/24 21:56
 * @Version 1.0
 */
public class _30_450_DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 终止条件
        // 中
        // 第一种情况，没找到 key，返回 null
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            //第二种情况，找到了 key，且 无子树，直接删除即可，返回 null 为根节点
            if (root.left == null && root.right == null) {
                return null;
            }
            // 第三种情况，找到了 key，左为 null，右不为 null，右替代他的位置
            if (root.left == null && root.right != null) {
                return root.right;
            }
            // 第四种情况，找到了 key，左不为 null，右为 null，左替代他的位置
            if (root.left != null && root.right == null) {
                return root.left;
            }
            // 第五种情况，左右都不为 null，左 要插在 右 的最左子树下
            if (root.left != null && root.right != null) {
                // 记录待删除 root 的 right
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }

        // 左
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // 右
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        return root;


    }
}
