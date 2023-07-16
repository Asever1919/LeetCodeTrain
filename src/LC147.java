import com.sun.org.apache.bcel.internal.generic.LNEG;

public class LC147 {
//    public static void main(String[] args) {
//        LC147 lc147 = new LC147();
//        int[] nums = {4, 2, 1, 3};
//        ListNode head = lc147.buildListNode(nums);
//        head = lc147.insertionSortList(head);
//        System.out.println("===");
//    }

//    private ListNode buildListNode(int[] nums) {
//        ListNode head = new ListNode(nums[0]);
//        ListNode cur = head;
//        for (int i = 1; i < nums.length; i++) {
//            cur.next = new ListNode(nums[i]);
//            cur = cur.next;
//        }
//        return head;
//    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-5001);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val >= pre.val) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode temp = cur;
                cur = cur.next;
                pre.next = cur;
                temp.next = null;
                insertNode(dummy, temp);
            }
        }
        return dummy.next;
    }

    private void insertNode(ListNode dummy, ListNode temp) {
        if (dummy.next == null || temp == null) return;
        ListNode nodeH = dummy.next;
        ListNode preH = dummy;
        while (nodeH.val < temp.val && nodeH != null) {
            preH = nodeH;
            nodeH = nodeH.next;
        }
        temp.next = nodeH;
        preH.next = temp;
    }

}
