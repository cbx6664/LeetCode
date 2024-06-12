import org.junit.Test;

import java.util.*;

/**
 * ClassName: _4_102_BinaryTreeLevelOrderTraversal
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author CBX
 * @Create 2024/6/9 11:48
 * @Version 1.0
 */
public class _5_429_N_aryTreeLevelOrderTraversal {
    @Test
    public void test1() {
        Node node = new Node(1, Arrays.asList(
                new Node(2),
                new Node(3, Arrays.asList(
                        new Node(6),
                        new Node(7, Arrays.asList(
                                new Node(11, Arrays.asList(
                                        new Node(14)
                                )),
                                new Node(12)
                        ))
                )),
                new Node(4, Arrays.asList(
                        new Node(8)
                )),
                new Node(5, Arrays.asList(
                        new Node(9, Arrays.asList(
                                new Node(13)
                        )),
                        new Node(10)
                ))
        ));
        System.out.println(levelOrder(node));

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            //每一层用一个list存放value
            List<Integer> eachLevel = new ArrayList<>();
            //记录每一层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                eachLevel.add(node.val);
                if (node.children != null) {
                    for (int j = 0; j < node.children.size(); j++) {
                        if (node.children.get(j) != null) {
                            queue.add(node.children.get(j));
                        }
                    }
                }
            }
            //把每一层的value list 存入result
            result.add(eachLevel);
        }
        return result;
    }
}

