import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBSTAndCBT {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int data) {
            this.val = data;
        }
    }


    // 判断是否为二叉搜索树
    public static boolean isBST(Node head) {
        if (head == null) return true;
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && head.val <= pre.val) return false;
                pre = head;
                head = head.right;
            }
        }
        return true;
    }


    // 判断是否为完全二叉树CBT
    public static boolean isCBT(Node head) {
        if (head == null) return true;

        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);

        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
