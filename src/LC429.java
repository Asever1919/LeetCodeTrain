import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC429 {
    public class Node {
        public int val;
        public List<Node> children;
        public Node(){}
        public Node(int val){
            this.val = val;
        }
        public Node(int val, List<Node> _children){
            this.val = val;
            this.children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        if (root == null) return  res;
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> path = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                path.add(node.val);
                for (Node child : node.children) {
                    que.offer(child);
                }
            }
            res.add(new ArrayList<>(path));
        }
        return res;
    }
}
