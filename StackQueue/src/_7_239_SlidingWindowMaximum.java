import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

//解法一
//自定义数组
class Queue {
    Deque<Integer> deque = new LinkedList<>();
    //弹出元素时，比较当前要弹出的数值是否等于队列出口（队首）的数值，如果相等则弹出
    //同时判断队列当前是否为空
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }
    //添加元素时，如果要添加的元素大于入口处（队尾）的元素，就将入口元素（队尾的元素）弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1， 2将要入队，比1大，所以1弹出，此时队列：3,2
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }
    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}

public class _7_239_SlidingWindowMaximum {
    @Test
    public void test1(){
        System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        //res数组的指针
        int num = 0;
        //自定义队列
        Queue myQueue = new Queue();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        //遍历nums
        for (int i = k; i < nums.length; i++) {
            //每次for循环，滑动窗口都后移一位，所以要先删除queue中队首元素，再添加新的元素到队尾

            //移除队首的元素，移除时判断该元素是否在队列中
            myQueue.poll(nums[i - k]);
            //加入元素到队尾
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }
}