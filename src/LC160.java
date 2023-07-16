public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)return null;
        ListNode cur1 = headA;
        int lenA = 0;
        ListNode cur2 = headB;
        int lenB = 0;

        while (cur1 != null) {
            lenA++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            lenB++;
            cur2 = cur2.next;
        }
        cur1 = headA;
        cur2 = headB;
        if (lenB > lenA) {
            int temp = lenA;
            lenA = lenB;
            lenB = temp;

            ListNode tempCur = cur1;
            cur1 = cur2;
            cur2 = tempCur;
        }
        int gap = lenA - lenB;
        while (gap-- > 0) {
            cur1 = cur1.next;
        }
        while (cur1 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
