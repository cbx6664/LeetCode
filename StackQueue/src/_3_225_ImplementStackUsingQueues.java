import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: _3_225_ImplementStackUsingQueues
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/2 14:40
 * @Version 1.0
 */
public class _3_225_ImplementStackUsingQueues {
    @Test
    public void test1(){
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        //初始化
        queue = new LinkedList<>();
    }

    public void push(int x) {
        //添加一个元素x, 然后移动queue中除了x的所有元素，使x为队首
        queue.offer(x);
        //移动queue中除了x的所有元素，使x为队首
        int size = queue.size();
        while (size != 1) {
            queue.offer(queue.poll());
            size--;
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}


