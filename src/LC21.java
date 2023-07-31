public class LC21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 首先，这是链表构造，那么必须有返回值。
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}
