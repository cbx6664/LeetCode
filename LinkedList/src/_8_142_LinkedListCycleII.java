import org.junit.Test;

/**
 * ClassName: _8_142_LinkedListCycleII
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/23 21:10
 * @Version 1.0
 */
public class _8_142_LinkedListCycleII {
    @Test
    public void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        detectCycle(n1);
    }

    public ListNode detectCycle(ListNode head) {
        //快慢指针检测是否有环
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            //快指针每次走两步
            fast = fast.next.next;
            //慢指针每次走一步
            slow = slow.next;
            if (fast == slow) {
                //如果快慢指针相遇，说明有环
                //将慢指针指向头节点，快指针指向相遇节点不动，然后快慢指针每次走一步，下一次相遇的节点就是环的入口节点
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;

            }
        }
        return null;
    }
}
