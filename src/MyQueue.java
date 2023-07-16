import java.util.Stack;

public class MyQueue {
    // 无参构造
    MyQueue (){}
    // 两个栈
    Stack<Integer> stIn = new Stack<>();
    Stack<Integer> stOut = new Stack<>();
    // push
    public void push(int x) {
        stIn.push(x);
    }
    // peek
    public int pop() {
        dum();
        return stOut.pop();
    }

    // poll
    public int peek() {
        dum();
        return stOut.peek();
    }
    // empty
    public boolean empty() {
        return stIn.isEmpty() && stOut.isEmpty();
    }
    public void dum() {
        if (stOut.isEmpty()) return;
        while (!stIn.isEmpty()) {
            stOut.push(stIn.pop());
        }
    }
}
