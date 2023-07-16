import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;
    Node next;
    public Node(){}
    public Node(int val){this.val = val;}
    public Node(int val, Node left, Node right, Node next){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
public class LC117 {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            Node preNode = null;
            Node node = null;

            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    node = que.poll();
                    preNode = node;
                } else {
                    node = que.poll();
                    preNode.next = node;
                    preNode = node;
                }
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            preNode.next = null;
        }
        return root;
    }
}
