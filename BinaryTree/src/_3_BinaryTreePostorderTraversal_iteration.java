import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
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
public class _3_BinaryTreePostorderTraversal_iteration {
    @Test
    public void test1() {
        TreeNode treeNode1 = new TreeNode(new TreeNode(new TreeNode(4), 2, new TreeNode(5)), 1, new TreeNode(new TreeNode(6), 3, null));
        TreeNode treeNode2 = new TreeNode(new TreeNode(new TreeNode(new TreeNode(new TreeNode(7), 5, null), 4, new TreeNode(6)), 2, null), 1, new TreeNode(3));

        System.out.println(postorderIterationTraversal(treeNode2));
    }

    public List<Integer> postorderIterationTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }

        //root入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            //弹出当前root
            TreeNode node = stack.pop();
            result.add(node.val);

            //先压入当前root的左子节点，再压入右子节点，因为栈是LIFO，
            // 反过来才是先弹出右子节点再弹出左子节点，最后反转得到--左右中
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);

        return result;
    }

}
