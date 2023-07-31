public class LC92 {
    public static void main(String[] args) {
        NumsBuildListNode numsBuildListNode = new NumsBuildListNode();
        int[] nums = {1, 2, 3, 4, 5};
        int left = 2;
        int right = 4;
        ListNode head = numsBuildListNode.buildListNode(nums);
        head = reverseBetween(head, left, right);

        System.out.println("   ");
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftNode = dummy;
        while (left-- > 1) {
            leftNode = leftNode.next;
        }

        ListNode rightNode = dummy;
        while (right-- > 0) {
            rightNode = rightNode.next;
        }

        ListNode temp = rightNode.next;


        rightNode.next = null;
        ListNode resNode = reverse(leftNode.next);
        ListNode curResNode = resNode;
        while (curResNode != null && curResNode.next != null) {
            curResNode = curResNode.next;
        }
        curResNode.next = temp;
        leftNode.next = resNode;

        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
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
