import com.sun.org.apache.bcel.internal.generic.LNEG;

public class NumsBuildListNode {

    public ListNode buildListNode(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }
}
