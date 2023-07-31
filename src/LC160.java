public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (lenB > lenA) {
            int templen = lenA;
            lenA = lenB;
            lenB = templen;

            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }

        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
