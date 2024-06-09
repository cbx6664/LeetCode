import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: _4_102_BinaryTreeLevelOrderTraversal
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/9 11:48
 * @Version 1.0
 */
public class _4_111_MinimumDepthofBinaryTree {
    @Test
    public void test1() {
        TreeNode treeNode2 = new TreeNode(new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 5, null), 4, new TreeNode(6)), 2, null), 1, new TreeNode(3));
        System.out.println(minDepth(treeNode2));

    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            //记录每一层的节点数
            int size = queue.size();
            //开始遍历新的一层，depth++
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //下一层的节点加入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left == null && node.right == null) {
                    return depth;
                }
            }
        }
        return depth;
    }
}
