import org.junit.Test;

/**
 * ClassName: _4_206_ReverseLinkedList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/22 12:49
 * @Version 1.0
 */
public class _4_206_ReverseLinkedList {
    @Test
    public void test1() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = l1;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        ListNode l2 = reverseList(l1);
        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
}
