import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _24_530_MinimumAbsoluteDifferenceinBST
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 21/11/24 17:40
 * @Version 1.0
 */
public class _24_530_MinimumAbsoluteDifferenceinBST {
    // BST 中序遍历是就是从小到大的数组，利用这一点，问题就变成了在一个递增数组中查找最小绝对差
    // 因为 BST 是递增的，且 在排序后的数组中，最小的绝对差一定出现在相邻元素之间
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;

    @Test
    public void test1() {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(1), 2, new TreeNode(3)), 4, new TreeNode(6));
        System.out.println(getMinimumDifference(node));
    }

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;

    }

    public void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);

        if (pre != null) {
            result = Integer.min(result, cur.val - pre.val);
        }
        // 记录上一次递归中的 root
        pre = cur;

        traversal(cur.right);
    }
}
