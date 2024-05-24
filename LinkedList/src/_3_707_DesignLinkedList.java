import org.junit.Test;

/**
 * ClassName: _3_707_DesignLinkedList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/5/21 17:45
 * @Version 1.0
 *//*

 */
/*
题意：

在链表类中实现这些功能：

get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
*/

//index输入异常判断没弄明白，浪费了好多时间，index输入异常应该直接return就行

public class _3_707_DesignLinkedList {
    @Test
    public void test1() {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.deleteAtIndex(1);
        obj.addAtHead(2);
        obj.addAtHead(7);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(5);
        obj.addAtHead(5);
        obj.addAtTail(5);
        obj.get(5);
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);


    }

}


class MyLinkedList {
    //链表结点个数
    int size;
    //虚拟头结点
    ListNode dummyHead;

    public MyLinkedList() {
        //初始化链表
        //记录链表元素数量
        size = 0;
        //虚拟头结点
        dummyHead = new ListNode(0);
    }

    public int get(int index) {
        //判断index是否合法
        if (index < 0 || index >= size) {
            return -1;
        }

        //获取虚拟头结点
        ListNode currentNode = dummyHead;

        //虚拟头结点占了一个位置，所以查找index+1节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.val;

    }

    public void addAtHead(int val) {
        //相当于在index=0之前插入
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        //相当于在index+1前插入
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        //前插法
        //判断index的合法性
        if (index < 0 || index > size) {
            return;
        }

        //记录要插入结点的前一个结点
        ListNode previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }

        //记录要插入结点
        ListNode toAdd = new ListNode(val);

        //插入节点
        toAdd.next = previous.next;
        previous.next = toAdd;

        size++;

    }

    public void deleteAtIndex(int index) {
        //前插法
        //判断index的合法性
        if (index < 0 || index >= size) {
            return;
        }

        //记录要删除结点的前一个结点
        ListNode previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }

        //删除节点
        previous.next = previous.next.next;

        size--;

    }
}
