import java.util.Deque;
import java.util.LinkedList;

public class LC239hard {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        int num = 0;
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.push(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }
    public class MyQueue{
        Deque<Integer> deque = new LinkedList<>();
        private void push (int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(val);
        }
        private void poll (int val) {
            if (!deque.isEmpty() && deque.peek() == val) {
                deque.poll();
            }
        }
        private int peek () {
            return deque.peek();
        }
    }
}
