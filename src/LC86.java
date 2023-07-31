public class LC86 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,0,5,2};
        NumsBuildListNode nbl = new NumsBuildListNode();
        ListNode head = nbl.buildListNode(nums);
        LC86 lc86 = new LC86();
        lc86.partition(head, 2);
    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode newNode = new ListNode(-1);
        ListNode preNode = newNode;
        while (cur.next != null) {
            if (cur.next.val < x){
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                temp.next = null;
                preNode.next = temp;
                preNode = preNode.next;
            } else {
                cur = cur.next;
            }
        }
        ListNode newCur = newNode;
        while (newCur.next != null) {
            newCur = newCur.next;
        }
        newCur.next = dummy.next;
        return newNode.next;
    }
}
