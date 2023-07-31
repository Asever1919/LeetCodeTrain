import java.util.Comparator;
import java.util.PriorityQueue;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        // 构建优先级队列，重写排序方法。
        PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        // 将元素添加进队列
        for (int num : nums) {
            que.add(num);
        }
        // 注意第k个大，不要把第k个移除。
        while (k-- > 1) {
            que.remove();
        }
        return que.peek();
    }
}
