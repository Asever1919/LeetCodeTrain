import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 键值关系
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 优先级队列
//        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>(((o1, o2) -> o2.getValue() - o1.getValue()));
        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>(((o1, o2) -> o2.getValue() - o1.getValue()));
        for (Map.Entry<Integer, Integer> entry : entries) {
            que.offer(entry);
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = que.poll().getKey();
        }
        return res;
    }
}
