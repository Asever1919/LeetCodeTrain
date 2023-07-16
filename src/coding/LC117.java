package coding;

import java.util.LinkedList;
import java.util.Queue;

public class LC117 {
    public class Node {
        int val;
        Node left;
        Node right;
        Node next;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = left;
            this.next = next;
        }
    }
    public Node connect(Node root) {
        Queue<Node> que = new LinkedList<>();
        if (root == null) return root;
        que.offer(root);

        while (!que.isEmpty()) {
            Node node = null;
            Node preNode = null;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    node = que.poll();
                    preNode = node;
                } else {
                    node = que.poll();
                    preNode.next = node;
                    preNode = node;
                }
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            preNode.next = null;
        }
        return root;
    }
}
