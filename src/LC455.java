import java.lang.reflect.Array;
import java.util.Arrays;

public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            if (index <= g.length - 1 && s[i] >= g[index]) {
                res++;
                index++;
            }
        }
        return res;
    }
}
