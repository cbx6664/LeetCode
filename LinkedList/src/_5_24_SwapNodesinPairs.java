import org.junit.Test;

/**
 * ClassName: _5_24_SwapNodesinPairs
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/22 13:36
 * @Version 1.0
 */
public class _5_24_SwapNodesinPairs {
    @Test
    public void test1() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode l2 = swapPairs(l1);
        System.out.println(l2);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            ListNode next = curr.next.next;
            curr.next.next = curr;
            curr.next = next;
            //每完成一次调换就更新指针
            prev = curr;
            curr = next;

        }

        return dummyHead.next;

    }
}
