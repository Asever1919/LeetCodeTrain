import javax.swing.text.LabelView;

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 整体思路：两个指针寻找数量为k的首和尾
        // 使用虚拟头节点
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        // 注意，end对应的是虚拟头节点。
        ListNode end = dummy;

        // 寻找能够满足反转的区间。
        while (end != null){
            // 下面的代码都是判断能不能链表节点能不能到k个
            for (int i = 0; i < k; i++) {
                if (end != null) {
                    end = end.next;
                }
                // 如果有节点为空，就肯定是不满足k个节点了。
                if (end == null) {
                    break;
                }
            }
            // 因为end初始为初始头节点，所以还要判断下一个节点的情况。跳出整个循环。
            if (end == null) {
                break;
            }

            // 没什么问题就开始反转链表
            ListNode start = pre.next;
            ListNode temp = end.next;
            // 截断链表
            end.next = null;
            pre.next = reverse(start);

            // 连接链表
            start.next = temp;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }
    // 反转链表
    public ListNode reverse(ListNode head) {
        if (head == null) return head;
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
