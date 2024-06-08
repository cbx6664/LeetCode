import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * ClassName: test_java_stack_queue
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/2 13:32
 * @Version 1.0
 */
/*使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。*/

public class _2_232_ImplementQueueUsingStacks {
    @Test
    public void test1() {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}

class MyQueue {
    //使用两个栈实现队列，一个是输入栈，一个是输出栈，因为栈是FILO,队列是FIFO
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        //初始化
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        //压入输入栈
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();

    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpStackIn() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
