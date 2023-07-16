public class LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 1.寻找中间节点。
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 2.反转中间节点next节点及之后的链表。这里slow是偏左，所以要从slow.next反转。
        slow = reverse(slow.next);
        // 3.比较head链表和反转之后的节点的

        while (slow != null) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
