import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: _4_102_BinaryTreeLevelOrderTraversal
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/9 11:48
 * @Version 1.0
 */
public class _4_116_PopulatingNextRightPointersinEachNode {
    @Test
    public void test1() {
        Node root = new Node(1, new Node(2, new Node(4, null, null, null), new Node(5, null, null, null), null), new Node(3, new Node(6, null, null, null), new Node(7, null, null, null), null), null);
        System.out.println(connect(root));

    }

    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            //记录每一层的节点数
            int size = queue.size();
            //cur指针记录每行最左边的节点
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }

            for (int i = 1; i < size; i++) {
                //next指针记录cur后一个的节点
                Node next = queue.poll();
                if (next.left != null) {
                    queue.add(next.left);
                }
                if (next.right != null) {
                    queue.add(next.right);
                }
                cur.next = next;
                cur = next;

            }
        }

        return root;
    }
}
