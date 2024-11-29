import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: _08_40_CombinationSumII
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 29/11/24 17:04
 * @Version 1.0
 */
public class _08_40_CombinationSumII {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    void backTracking(int[] candidates, int target, int sum, int startIndex, boolean[] used) {
        if (sum == target) {
            // 注意，添加 path 时要 new list，否则 path 是全局变量，后续的改变会在 result 中体现
            result.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 已经将 candidate 排序好了，才能这样判断
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backTracking(candidates, target, sum, i + 1, used);
            path.removeLast();
            sum -= candidates[i];
            used[i] = false;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backTracking(candidates, target, 0, 0, used);
        return result;
    }

    @Test
    public void test1() {
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
