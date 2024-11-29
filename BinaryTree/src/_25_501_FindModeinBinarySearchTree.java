import org.junit.Test;

import java.util.*;

/**
 * ClassName: _25_501_FindModeinBinarySearchTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 23/11/24 10:33
 * @Version 1.0
 */
public class _25_501_FindModeinBinarySearchTree {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(null, 1, new TreeNode(new TreeNode(2), 2, null));
//        findMode(root);
        findModeWithMap(root);
    }

    // 记录节点重复数量
    int count = 0;

    // 记录最大重复数量
    int maxCount = 0;

    // 记录上一个节点
    TreeNode pre = null;

    // 记录众数数组
    List<Integer> result = new ArrayList<>();

    // 暴力使用 map 记录
    HashMap<Integer, Integer> map = new HashMap<>();

    public void bruteForce(TreeNode root) {
        if (root == null) {
            return;
        }

        // 左
        bruteForce(root.left);
        // 中
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        // 右
        bruteForce(root.right);

    }

    public int[] findModeWithMap(TreeNode root) {
        bruteForce(root);
        int max = Collections.max(map.values());
        return map.entrySet().stream().filter(entry -> entry.getValue() == max)
                .mapToInt(Map.Entry::getKey)
                .toArray();

    }

    public int[] findMode(TreeNode root) {
        traversal(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void traversal(TreeNode root) {
        // 终止条件
        if (root == null) {
            return;
        }

        // 左
        traversal(root.left);

        // 中
        // 如果没有前一个节点，或者pre 和 cur 的值不同，count 为 1
        if (pre == null || pre.val != root.val) {
            count = 1;
        } else {
            // 如果前一个节点和当前节点一样，count++
            count++;
        }

        // 如果 count 大于等于 maxCount，更新 maxCount 记录和 result
        if (count > maxCount) {
            result.clear();
            maxCount = count;
            result.add(root.val);
        } else if (count == maxCount) {
            result.add(root.val);
        }

        // 设置 pre
        pre = root;

        // 右
        traversal(root.right);

    }
}
