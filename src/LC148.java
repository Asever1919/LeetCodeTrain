import com.sun.org.apache.bcel.internal.generic.LNEG;

public class LC148 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 5, 3, 4, 0};
        NumsBuildListNode nbl = new NumsBuildListNode();
        ListNode head = nbl.buildListNode(nums);
//        head = sortList(head);
        System.out.println(" ");
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return mergeNode(head);
    }

    private ListNode mergeNode(ListNode head) {
        // 如果没有节点或者一个节点
        if (head == null || head.next == null) {
            return head;
        }
        // 经典快慢指针寻找中间节点
        ListNode fast = head.next.next, slow = head, l, r;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        r = mergeNode(slow.next);
        slow.next = null;
        l = mergeNode(head);
        return mergeList(l, r);
    }

    private ListNode mergeList(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                pre.next = l;
                l = l.next;
            } else {
                pre.next = r;
                r = r.next;
            }
            pre = pre.next;
        }
        pre.next = (l == null ? r : l);
        return dummy.next;
    }

}
