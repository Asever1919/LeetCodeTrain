public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int n = k % size;
        if (n == 0) return head;
        int num = size - n;
        cur = head;
        ListNode pre = null;
        while (num-- > 0) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        ListNode newHead = cur;
        while (--n > 0) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }
}
