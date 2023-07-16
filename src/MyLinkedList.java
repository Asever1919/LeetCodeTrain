public class MyLinkedList {
    public class ListNode {
        // 链表的构造，值，指针，有参无参。
        int val;
        ListNode next;
        ListNode (){}
        ListNode (int val){this.val = val;}
        ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    int size;
    ListNode head;
    public MyLinkedList() {
        // 初始化
        size = 0;
        head = new ListNode(0);

    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode cur = head;
        while (index-- >= 0) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
//        寻找目标节点，也就是index，并考虑几种情况。
        if (index > size) return;
        if (index < 0) index = 0;
        size++;
        ListNode pre = head;
        while (index-- > 0) {
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode pre = head;
        while (index-- > 0) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
