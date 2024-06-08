import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _2_BinaryTreeTraversal
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/8 17:40
 * @Version 1.0
 */
public class _2_145_BinaryTreePostorderTraversal {
    @Test
    public void test1() {
        TreeNode treeNode1 = new TreeNode(new TreeNode(new TreeNode(4), 2, new TreeNode(5)), 1, new TreeNode(new TreeNode(6), 3, null));

        System.out.println(postorderTraversal(treeNode1));

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> result) {
        //递归三要素
        //1. 确定递归函数的参数和返回值
        //参数就是树的节点，和存放value的容器，没有返回值

        //2. 确定终止条件
        //当前节点是null时，本层递归结束
        if (root == null) {
            return;
        }

        //3. 确定单层递归的逻辑
        //后序遍历，单层递归的逻辑是，先遍历左子节点，再遍历右子节点，最后是本节点的val
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }


}

