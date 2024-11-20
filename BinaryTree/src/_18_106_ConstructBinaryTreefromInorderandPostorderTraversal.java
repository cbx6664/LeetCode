import org.junit.Test;

import java.util.*;


/**
 * ClassName: _18_106_ConstructBinaryTreefromInorderandPostorderTraversal
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 19/11/24 14:45
 * @Version 1.0
 */
public class _18_106_ConstructBinaryTreefromInorderandPostorderTraversal {

    @Test
    public void test1() {
        int[] inorder = {2, 1};
        int[] postorder = {2, 1};
        TreeNode node = buildTree(inorder, postorder);
        System.out.println(levelOrder(node));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return traversalWithIndex(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode traversal(int[] inorder, int[] postorder) {
        // 统一为左闭右开
        // 中序：左根右，后序：左右根
        // 先获取root，后序最后一个元素
        if (postorder.length == 0) return null;
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);


        // 如果是叶子节点，直接返回 root
        if (postorder.length == 1) {
            return root;
        }

        // 切割中序遍历列表
        int inorderDelimiterIndex;
        for (inorderDelimiterIndex = 0; inorderDelimiterIndex < inorder.length; inorderDelimiterIndex++) {
            if (inorder[inorderDelimiterIndex] == rootValue) {
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, inorderDelimiterIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, inorderDelimiterIndex + 1, inorder.length);

        // 再切割后序遍历列表
        // 舍弃之前取出来过的后序遍历列表的最后一个元素
        postorder = Arrays.copyOfRange(postorder, 0, postorder.length - 1);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftPostorder.length, postorder.length);

        root.left = traversal(leftInorder, leftPostorder);
        root.right = traversal(rightInorder, rightPostorder);

        return root;
    }

    public TreeNode traversalWithIndex(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // 统一为左闭右开
        // 中序：左根右，后序：左右根
        // 先获取root，后序最后一个元素
        if (postStart > postEnd) return null;
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);


        // 如果是叶子节点，直接返回 root
        if (postStart == postEnd) {
            return root;
        }

        // 切割中序遍历列表
        int inorderDelimiterIndex;
        for (inorderDelimiterIndex = 0; inorderDelimiterIndex < inorder.length; inorderDelimiterIndex++) {
            if (inorder[inorderDelimiterIndex] == rootValue) {
                break;
            }
        }

        int leftInorderLength = inorderDelimiterIndex - inStart;
//
//        int[] leftInorder = Arrays.copyOfRange(inorder, 0, inorderDelimiterIndex);
//        int[] rightInorder = Arrays.copyOfRange(inorder, inorderDelimiterIndex + 1, inEnd);
//
//        // 再切割后序遍历列表
//        // 舍弃之前取出来过的后序遍历列表的最后一个元素
//        postorder = Arrays.copyOfRange(postorder, 0, postorder.length - 1);
//        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
//        int[] rightPostorder = Arrays.copyOfRange(postorder, leftPostorder.length, postorder.length);

        root.left = traversalWithIndex(inorder, inStart, inorderDelimiterIndex, postorder, postStart, postStart + leftInorderLength - 1);
        root.right = traversalWithIndex(inorder, inorderDelimiterIndex + 1, inEnd, postorder, postStart + leftInorderLength, postEnd - 1);

        return root;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
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
