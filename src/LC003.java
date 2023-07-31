import java.util.HashMap;
import java.util.Map;

public class LC003 {
    public int lengthOfLongestSubstring(String s) {
        // 使用map
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int lowIndex = 0;
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                // 这里为什么+1，哪里重复了，就从重复的下一个开始。
                lowIndex = Math.max(lowIndex, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - lowIndex + 1);
        }
        return res;
    }
}
