import java.util.HashMap;

public class Offer35_Clone {

    // 定义复杂链表
    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int data) {
            this.val = data;
        }
    }

    // 1.hash解决方案
    public Node clone(Node head) {
        if (head == null) return null;
        // 构建一个hashMap，key为Node，value为Node的复制值
        HashMap<Node, Node> hash = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            hash.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 给每个复制的结点赋值next和random指针
        cur = head;
        while (cur != null) {
            hash.get(cur).next = hash.get(cur.next);
            hash.get(cur).random = hash.get(cur.random);
            cur = cur.next;
        }

        return hash.get(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 在原链表的每个结点后面复制一个结点并连接成新链表
        Node cur = head;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // 对复制结点设置random指针，指向当前复制结点前一个结点的random指针的下一个节点
        cur = head;

        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // 分离
        Node res = head.next;
        cur = head;
        while (cur != null) {
            Node cloneNode = cur.next;
            cur.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            cur = cur.next;
        }
        return res;
    }


}
