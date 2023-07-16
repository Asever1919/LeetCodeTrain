public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
