import java.util.*;

public class LC187 {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> res = new ArrayList<>();;
//        Set<String> set = new HashSet<>();
        int[] flag = new int[s.length()];
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len && i + 9 < len; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) > 1 && flag[i] == 0) {
                res.add(str);

            }
        }
        return res;
    }
}
