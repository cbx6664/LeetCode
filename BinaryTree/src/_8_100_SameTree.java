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
/*
 * 给定两个二叉树，检查它是否是相同的。
 * 利用了层次遍历二叉树，把null也保存在eachLevel数组中，然后通过对比每一层的节点value数组，
 * 如果两棵树的节点数组完全相同则 是相同的二叉树
 * */
public class _8_100_SameTree {
    @Test
    public void test1() {
        TreeNode treeNode2 = new TreeNode(new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 5, null), 4, new TreeNode(6)), 2, null), 1, new TreeNode(3));
        TreeNode node3 = new TreeNode(new TreeNode(new TreeNode(3), 2, new TreeNode(4)), 1, new TreeNode(new TreeNode(4), 2, new TreeNode(3)));
        TreeNode node4 = new TreeNode(new TreeNode(null, 2, new TreeNode(3)), 1, new TreeNode(null, 2, new TreeNode(3)));
        TreeNode node5 = new TreeNode(new TreeNode(null, 2, new TreeNode(3)), 1, new TreeNode(null, 2, new TreeNode(3)));

        System.out.println(isSameTree(node4, node5));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<List<Integer>> list1 = levelTraversal(p);
        List<List<Integer>> list2 = levelTraversal(q);
        if (list1.equals(list2)) {
            return true;
        }
        return false;

    }

    public List<List<Integer>> levelTraversal(TreeNode root) {
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
                if (node != null) {
                    eachLevel.add(node.val);
                } else eachLevel.add(null);

                //下一层的节点加入队列
                if (node != null && node.left != null) {
                    queue.add(node.left);
                }
                if (node != null && node.left == null) {
                    queue.add(null);
                }

                if (node != null && node.right != null) {
                    queue.add(node.right);
                }
                if (node != null && node.right == null) {
                    queue.add(null);
                }

            }
            result.add(eachLevel);
        }
        return result;
    }
}
