import org.junit.Test;

/**
 * ClassName: _6_19_RemoveNthNodeFromEndofList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/22 15:39
 * @Version 1.0
 */
public class LinkedList_6_19_RemoveNthNodeFromEndofList {
    @Test
    public void test1(){
        //删除倒数第二个节点
        ListNode l2 = removeNthFromEnd(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),2);
        System.out.println(l2);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        //虚拟头结点指向真实头节点
        dummyHead.next = head;
        //创建fast和slow指针
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        //先让fast指针往后移动n+1位
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //fast和slow一起往后移动，直到fast指向了null
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
