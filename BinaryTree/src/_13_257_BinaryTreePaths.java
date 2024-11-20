import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _13_257_BinaryTreePaths
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 12/11/24 20:54
 * @Version 1.0
 */
public class _13_257_BinaryTreePaths {
    @Test
    public void test1(){
        TreeNode treeNode3 = new TreeNode(new TreeNode(null,2,new TreeNode(5)),1,new TreeNode(3));
        System.out.println(binaryTreePaths(treeNode3));

    }

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        preorder(root, "");
        return result;
    }

    public void preorder(TreeNode root, String s) {
        //递归三要素
        //1. 确定递归函数的参数和返回值
        //参数就是树的节点，和存放value的容器，没有返回值

        //2. 确定终止条件
        //当前节点是null时，本层递归结束
        if (root == null) {
            return;
        }

        //当左右子节点都为空时，说明到了叶子节点，将路径添加到结果集中
        if (root.left == null && root.right == null) {
            result.add(new StringBuilder(s).append(root.val).toString());
            return;
        }

        //3. 确定单层递归的逻辑
        //前序遍历，单层递归的逻辑是，先添加本节点的val，然后遍历左子节点，再遍历右子节点
        //将当前节点的值添加到路径中
        String temp = new StringBuilder(s).append(root.val).append("->").toString();
        preorder(root.left, temp);
        preorder(root.right, temp);
    }

}
