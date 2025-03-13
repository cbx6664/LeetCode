import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _11_78_Subsets
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 3/12/24 12:12
 * @Version 1.0
 */
public class _11_78_Subsets {
    @Test
    public void test1() {
        subsets(new int[]{1, 2, 3});
        for (List<Integer> integer : result) {
            System.out.println(integer.toString());
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        // 每个集合都有空子集
        result.add(new ArrayList<>());
        return result;
    }

    void backTracking(int[] nums, int startIndex) {
        if (path.size() != 0) {
            result.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
