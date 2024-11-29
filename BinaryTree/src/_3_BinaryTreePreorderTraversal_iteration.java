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
public class _3_BinaryTreePreorderTraversal_iteration {
    @Test
    public void test1() {
        TreeNode treeNode1 = new TreeNode(new TreeNode(new TreeNode(4), 2, new TreeNode(5)), 1, new TreeNode(new TreeNode(6), 3, null));
        TreeNode treeNode2 = new TreeNode(new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 5, null), 4, new TreeNode(6)), 2, null), 1, new TreeNode(3));

        System.out.println(preorderIterationTraversal(treeNode2));
    }

    public List<Integer> preorderIterationTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }

        //root入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // ！！！ 注意这一步，是弹出当前root，是动态的, 否则会造成死循环
            TreeNode node = stack.pop();
            result.add(node.val);

            //先压入当前root的右子节点，再压入左子节点，因为栈是LIFO，反过来才是先弹出左子节点再弹出右子节点
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

}
