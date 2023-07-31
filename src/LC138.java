import java.util.HashMap;
import java.util.Map;

public class LC138 {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node node = head;
        // 通过map的映射关系来进行
        Map<Node, Node> map = new HashMap<>();

        // 存储映射关系：
        while (node != null) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            node = node.next;
        }

        // 根据映射关系进行映射。
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}

