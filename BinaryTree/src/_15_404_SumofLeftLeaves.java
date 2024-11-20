import org.junit.Test;

import java.util.Stack;

/**
 * ClassName: _15_404_SumofLeftLeaves
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 12/11/24 21:53
 * @Version 1.0
 */
public class _15_404_SumofLeftLeaves {
    @Test
    public void test1(){
        TreeNode treeNode3 = new TreeNode(new TreeNode(9),3,new TreeNode(new TreeNode(15),20,new TreeNode(7)));
        System.out.println(sumOfLeftLeaves(treeNode3));

    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }
}
