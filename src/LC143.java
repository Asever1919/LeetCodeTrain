public class LC143 {
    public void reorderList(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            cur.next = reverse(cur.next);
            cur = cur.next;
        }
    }
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
