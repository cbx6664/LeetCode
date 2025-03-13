import org.junit.Test;

import java.util.*;

/**
 * ClassName: _239_SlidingWindowMaximum
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 10/12/24 16:48
 * @Version 1.0
 */
public class _239_SlidingWindowMaximum {
    @Test
    public void test1() {
//        maxSlidingWindowBF(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        // 双端队列存储的是数组的索引，而不是值
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // 移除窗口外的索引（窗口的起始位置为 i - k + 1）
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 从后面移除小于当前值的索引，保持队列递减
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 将当前索引加入队列
            deque.addLast(i);

            // 记录窗口最大值，当窗口形成后（即 i >= k - 1）
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;

    }


    public int[] maxSlidingWindowBF(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        for (int i = k - 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = start; j <= i; j++) {
                max = Math.max(nums[j], max);
            }
            list.add(max);
            start++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
