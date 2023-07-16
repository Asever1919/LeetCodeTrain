import java.util.ArrayList;
import java.util.List;

public class LC763 {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] edge = new int[26];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            edge[c[i] - 'a'] = i;
        }
        int index = 0;
        // 这里-1，是因为index - last求的是长度，直接初始化就好了。
        int last = -1;
        for (int i = 0; i < c.length; i++) {
            // index：表示一个区域内字符串的最远距离。比如absdagght，index就代表absda的最远距离a所在的位置。
            index = Math.max(index, edge[c[i] - 'a']);
            if (index == i) {
                list.add(index - last);
                last = index;
            }
        }
        return list;
    }
}
