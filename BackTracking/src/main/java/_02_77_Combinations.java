import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _02_77_Combinations
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 25/11/24 16:12
 * @Version 1.0
 */
public class _02_77_Combinations {
    // n 个数抽 k 个构成组合，有多少种？

    @Test
    public void test1() {
        combine(4, 2);
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startNumber) {
        // 终止条件
        if (path.size() == k) {
            // 存放结果
            result.add(new ArrayList<>(path));
            return;
        }

        // 选择本层集合中的元素
        for (int i = startNumber; i <= n; i++) {
            // 处理节点
            path.add(i);
            backtracking(n, k, i + 1);
            // 回溯，撤销处理结果
            path.removeLast();
        }
    }


}
