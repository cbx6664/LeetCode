import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: _16_513_FindBottomLeftTreeValue
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 13/11/24 14:36
 * @Version 1.0
 */
public class _16_513_FindBottomLeftTreeValue {

    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(4), 2, null), 1, new TreeNode(new TreeNode(new TreeNode(7), 5, null), 3, new TreeNode(6)));
        System.out.println(findBottomLeftValue(node));
    }

    public int findBottomLeftValue(TreeNode root) {
        // 层次遍历，找到最后一层的第一个节点
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int result = 0;
        while (!queue.isEmpty()) {
            // 记录每层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 弹出一个节点（出队列）
                TreeNode node = queue.poll();
                if (i == 0) {
                    result = node.val;
                }
                // 子节点入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
