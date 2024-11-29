import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: _07_39_CombinationSum
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 29/11/24 15:54
 * @Version 1.0
 */
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

public class _07_39_CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    void backTracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            // 注意，添加 path 时要 new list，否则 path 是全局变量，后续的改变会在 result 中体现
            result.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, sum, i);
            path.removeLast();
            sum -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return result;
    }

    @Test
    public void test1() {
        combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
