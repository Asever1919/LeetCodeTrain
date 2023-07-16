public class LC0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
        if (lenA < lenB) {
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        while (curA != null) {
            if (curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
