import com.sun.org.apache.bcel.internal.generic.LNEG;

public class LC143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tempNode = slow.next;
        slow.next = null;
        tempNode = reverse(tempNode);
        ListNode cur = head;
        while (cur != null && tempNode != null) {
            ListNode curNext = cur.next;
            ListNode tempNodeNext = tempNode.next;

            tempNode.next = cur.next;
            cur.next = tempNode;

            cur = curNext;
            tempNode = tempNodeNext;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return head;
    }
}
