public class LC1019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        LC1019 lc1019 = new LC1019();
        lc1019.nextLargerNodes(head);
    }
    public int[] nextLargerNodes(ListNode head) {

        int[] res = new int[3];
        ListNode cur = reverseListAndCount(head);
        System.out.println(cur.val);
        int max = cur.val;
        for (int i = 3 - 1; i >= 0; --i) {
            if (cur.val < max) {
                res[i] = max;
                System.out.println(res[i]);
            } else {
                max = cur.val;
            }
            if (cur.next != null)cur = cur.next;
        }
        return res;
    }
    private ListNode reverseListAndCount(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null ) {
            ListNode temp = cur.next;
            cur.next = pre;
            System.out.println(cur.val);
            pre = cur;
            System.out.println(pre.val);
            cur = temp;
        }
        return pre;
    }
}
