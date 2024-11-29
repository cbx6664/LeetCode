import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _03_216_CombinationSumIII
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 25/11/24 16:43
 * @Version 1.0
 */
public class _03_216_CombinationSumIII {
    // 1-9 抽 k 个数，加起来是 n 的组合个数
    @Test
    public void test1() {
        List<List<Integer>> list = combinationSum3(3, 7);
        System.out.println(list);

    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

//
//    void backtracking(参数) {
//        if (终止条件) {
//            存放结果;
//            return;
//        }
//
//        for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
//            处理节点;
//            backtracking(路径，选择列表); // 递归
//            回溯，撤销处理结果
//        }
//    }

    public void backTracking(int k, int n, int startNumber, int sum) {
        // 终止条件
        if (path.size() > k) {
            return;
        }
        if (sum > n) {
            return;
        }

        if (path.size() == k && sum == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startNumber; i <= 9; i++) {
            path.add(i);
            sum += i;
            backTracking(k, n, i + 1, sum);
            path.removeLast();
            sum -= i;
        }


    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1, 0);
        return result;

    }
}
