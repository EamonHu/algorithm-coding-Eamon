import java.util.Stack;

public class IsPalindromeList {
    public static class Node {
        int val;
        Node next;

        Node(int data) {
            this.val = data;
        }
    }

    // 利用栈，需要n的额外空间
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();

        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 快慢指针加栈，需要N/2额外空间
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head.next;  // 这样保证慢指针在后半部分的起点位置
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) return true;

        // 找到中间节点
        Node n1 = head;
        Node n2 = head;

        while (n2.next != null || n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        // 反转右边链表
        n2 = n1.next;// n2 指向右边第一个节点
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        // 比较两个链表
        n3 = n1; // save last node
        n2 = head; // n2 -> left first node
        boolean res = true;
        while (n1 != null || n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        // 还原链表
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void main(String[] args) {
        Node head = null;
        System.out.println(isPalindrome2(head));
        head = new Node(1);
        System.out.println(isPalindrome2(head));
        head = new Node(1);
        head.next = new Node(2);
        System.out.println(isPalindrome2(head));
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println(isPalindrome2(head));
    }

}
