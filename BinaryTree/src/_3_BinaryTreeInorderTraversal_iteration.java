import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: _3_BinaryTreePreorderTraversal_iteration
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/8 18:40
 * @Version 1.0
 */
public class _3_BinaryTreeInorderTraversal_iteration {
    @Test
    public void test1() {
        TreeNode treeNode1 = new TreeNode(new TreeNode(new TreeNode(4), 2, new TreeNode(5)), 1, new TreeNode(new TreeNode(6), 3, null));
        TreeNode treeNode2 = new TreeNode(new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 5, null), 4, new TreeNode(6)), 2, null), 1, new TreeNode(3));

        System.out.println(inorderIterationTraversal(treeNode2));
    }

    public List<Integer> inorderIterationTraversal(TreeNode root) {
        //result保存结果
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //初始化一个stack来辅助遍历
        Stack<TreeNode> stack = new Stack<>();

        //指针cur跟踪当前节点
        TreeNode cur = root;
        //所有左子节点依次入栈
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                //左子节点遍历完后开始将value导入result
                cur = stack.pop();
                result.add(cur.val);
                //cur指向右子节点
                cur = cur.right;
            }

        }

        return result;
    }

}
