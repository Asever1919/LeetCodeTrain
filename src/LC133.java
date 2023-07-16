import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return node == null ? null : help(node);

    }
    private Node help(Node node){

        Node copy = map.getOrDefault(node.val, new Node());
        // 判断map中当前node节点是否已经被复制。
        if (copy.val == 0) {
            // 如果没有，先从值开始复制。
            copy.val = node.val;
            // 将没添加的节点用map记录下。
            map.put(copy.val, copy);
            // 把与node节点相连的节点也复制过来。
            for (Node n : node.neighbors) {
                copy.neighbors.add(help(n));
            }
        }
        return copy;
    }
}
