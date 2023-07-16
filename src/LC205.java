import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class LC205 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode (){}
        ListNode (int val){
            this.val = val;
        }
        ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(j));
            }
            if (!map2.containsKey(t.charAt(j))) {
                map2.put(t.charAt(j), s.charAt(i));
            }
            if (map1.get(s.charAt(i)) != t.charAt(j) || map2.get(t.charAt(j)) != s.charAt(i)) return false;
        }
        return true;
    }
    public boolean isIsomorphic1(String s, String t) {
        int[] nums = new int[128];
        Arrays.fill(nums, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (nums[i] != Integer.MAX_VALUE && nums[i] != s.charAt(i) - t.charAt(i)) return false;
            nums[s.charAt(i) - 'a'] = s.charAt(i) - t.charAt(i);
        }
        return true;
    }
}
