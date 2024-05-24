import org.junit.Test;

/**
 * ClassName: _2_203_RemoveLinkedListElements
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/23 11:46
 * @Version 1.0
 */
/*
题意：删除链表中等于给定值 val 的所有节点。

        示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]

        示例 2： 输入head = [], val = 1, 输出：[]

    示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
            */


public class _2_203_RemoveLinkedListElements {
    @Test
    public void test1() {
        System.out.println(removeElements(new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))), 6));

    }

    public ListNode removeElements(ListNode head, int val) {
        //头结点就满足删除条件的情况, 需要从头结点开始删
        while(head!=null && head.val==val){
            head = head.next;
        }

        //除头结点以外的的结点满足删除条件, 把头结点处理好的链表地址 传给curr, 开始删
        //要操作链表, 需要复制一个, 一个负责操作(curr), 一个负责展示(head)
        ListNode curr = head;
        while(curr!=null){
            while(curr.next!=null && curr.next.val == val){
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
