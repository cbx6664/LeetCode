import org.junit.Test;

/**
 * ClassName: _6_226_InvertBinaryTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/12 10:52
 * @Version 1.0
 */
/*
其实就是在遍历二叉树时把左右子树交换一下，我们使用了前序遍历和后序遍历
* */
public class _6_226_InvertBinaryTree {
    @Test
    public void test1() {
        System.out.println(invertTree(new TreeNode(new TreeNode(new TreeNode(1), 2, new TreeNode(3)), 4, new TreeNode(new TreeNode(6), 7, new TreeNode(9)))));
    }

    public TreeNode invertTree(TreeNode root) {
        //递归三要素
        //1. 确定递归函数的参数，返回值
        //参数就是root节点，返回值是反转后的root节点

        //2. 确定递归终止条件
        //递归的终止条件是：节点为null
        if (root == null) {
            return root;
        }
        //3. 确定单层递归的逻辑
        //把左右子节点当作root进行invert
        invertTree(root.left);
        invertTree(root.right);
        //再交换左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
