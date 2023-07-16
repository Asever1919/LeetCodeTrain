import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public MyStack () {

    }
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = new LinkedList<>();
        temp = q1;
        q1 = q2;
        q2 = temp;
    }
    public int peek() {
        return q1.peek();
    }
    public int pop() {
        return q1.poll();
    }
    public boolean empty() {
        return q1.isEmpty();
    }
}
