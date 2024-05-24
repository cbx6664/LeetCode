/**
 * ClassName: ListNode
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/4/23 11:48
 * @Version 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}
