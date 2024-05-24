package _3_house_rubber;

import org.junit.Test;

/**
 * ClassName: HouseRobberIII337
 * Package: week7
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/7 10:29
 * @Version 1.0
 */


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class _31_337HouseRobberIII {
    @Test
    public void test1(){
        System.out.println(rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
    }
    
    //长度为2的dp数组的含义:
    //dp[0]: 不偷当前结点, 最多的收益
    //dp[1]: 偷当前的结点, 最多的收益

    //二叉树一定要后序遍历, 这样才能 自底向上 计算最大收益

    public int rob(TreeNode root) {
        int[] dp = robAction1(root);
        return Math.max(dp[0], dp[1]);
    }

    //1. 确定递归函数的 参数, 返回值
    int[] robAction1(TreeNode root) {
        int dp[] = new int[2];

        //2. 确定终止条件
        if (root == null) {
            return dp;
        }

        //3.确定遍历顺序, 后序遍历, 自底向上计算
        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);

        //4. 确定单层递归的逻辑
        //dp[0]: 不偷当前节点, 所以获取 其左右子节点 偷与不偷 的最大收益
        //dp[1]: 偷当前结点, 获取当前结点的值和 左右子节点 不偷 的最大收益
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}

