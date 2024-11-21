import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class _5_102_BinaryTreeLevelOrderTraversal {
    @Test
    public void test1() {
        TreeNode treeNode2 = new TreeNode(new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 5, null), 4, new TreeNode(6)), 2, null), 1, new TreeNode(3));
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 11, new TreeNode(2)), 4, null), 5, new TreeNode(new TreeNode(13), 8, new TreeNode(new TreeNode(5), 4, new TreeNode(1))));

        System.out.println(levelOrder(node));

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            //每一层用一个list存放value
            List<Integer> eachLevel = new ArrayList<>();
            //记录每一层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //记录当前层节点的value
                eachLevel.add(node.val);
                //下一层的节点加入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //把每一层的value list 存入result
            result.add(eachLevel);
        }
        return result;
    }
}
