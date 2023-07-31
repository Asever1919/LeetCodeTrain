import java.util.HashMap;
import java.util.Map;

public class LC146 {
    // 定义双向链表，存储元素为key-value
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        DLinkedNode() {

        }

        DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    // 链表有了，建hash
    private Map<Integer, DLinkedNode> catchMap = new HashMap<Integer, DLinkedNode>();

    // 尺寸size
    private int size = 0;

    // 容量cap
    private int capacity;

    // 虚拟的头节点和虚拟的尾节点：解决边界问题，不用判断左右是否为空。
    DLinkedNode head;
    DLinkedNode tail;

    // 初始化缓存
    public LC146(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = catchMap.get(key);
        if (node == null) {
            return -1;
        }
        // 如果key存在，先通过哈希表定位，再移到头部。
        moveToHead(node);
        return node.value;

    }
    public void put(int key, int value) {
        LC146.DLinkedNode node = catchMap.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            LC146.DLinkedNode newNode = new LC146.DLinkedNode(key, value);
            // 添加进哈希表
            catchMap.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                LC146.DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                catchMap.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // 移动链表到头节点，用了就要调到链表前面。
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 添加链表到头节点
    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    // 删除链表
    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 移除尾节点，也就是移除最近未使用的缓存。
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

}

