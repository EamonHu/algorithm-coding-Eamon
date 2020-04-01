import java.util.HashMap;

public class Offer35_Clone {

    // 定义复杂链表
    public static class RandomNode{
        int val;
        RandomNode next;
        RandomNode random;

        RandomNode(int data){
            this.val = data;
        }
    }

    // 1.hash解决方案
    public RandomNode clone(RandomNode head){
        if(head == null) return null;
        // 构建一个hashMap，key为Node，value为Node的复制值
        HashMap<RandomNode, RandomNode> hash = new HashMap<>();
        RandomNode cur = head;
        while(cur != null){
            hash.put(cur, new RandomNode(cur.val));
            cur = cur.next;
        }

        // 给每个复制的结点赋值next和random指针
        cur = head;
        while(cur != null){
            hash.get(cur).next = hash.get(cur.next);
            hash.get(cur).random = hash.get(cur.random);
            cur = cur.next;
        }

        return hash.get(head);
    }

    public static RandomNode copy2(RandomNode head){
        if(head == null) return null;

        // 在原链表的每个结点后面复制一个结点并连接成新链表
        RandomNode cur = head;
        RandomNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = new RandomNode(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // 对复制结点设置random指针，指向当前复制结点前一个结点的random指针的下一个节点
        cur  = head;
        RandomNode curCopy = null;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next: null;
            cur = next;
        }

        // 分离
        RandomNode res = head.next;
        cur = head;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.next = next != null ? next.next: null;
            cur = next;
        }
        return res;
    }
}
