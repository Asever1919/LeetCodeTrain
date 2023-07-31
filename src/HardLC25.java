import com.sun.org.apache.bcel.internal.generic.LNEG;

public class HardLC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 整体思路就是双指针控制区间反转。
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        // end去控制反转链表的末尾。
        while (end != null) {
            // 先看剩余链表是否满足k个。
            for (int i = 0; i < k; i++) {
                if (end != null) {
                    end = end.next;
                }
                if (end == null) {
                    break;
                }
            }
            if (end == null) {
                break;
            }
            // 分别存储节点
            ListNode start = pre.next;
            ListNode tempNext = end.next;

            // 截断链表
            end.next = null;
            // 反转
            pre.next = reverse(start);
            start.next = tempNext;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    // 常规反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
