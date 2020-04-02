import java.util.Stack;

public class PreInPosTraversal {
    // 定义节点
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int data) {
            this.val = data;
        }

    }

    // 前序递归
    public static void preTraversal(Node head) {
        if (head == null) return;

        System.out.print(head.val + " ");
        preTraversal(head.left);
        preTraversal(head.right);
    }

    // 中序递归
    public static void inTraversal(Node head) {
        if (head == null) return;
        inTraversal(head.left);
        System.out.print(head.val + " ");
        inTraversal(head.right);
    }

    // 后序递归
    public static void posTraversal(Node head) {
        if (head == null) return;

        posTraversal(head.left);
        posTraversal(head.right);
        System.out.print(head.val + " ");
    }

    // 前序非递归
    public static void preTravelsal1(Node head) {
        if (head == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.val + " ");
            if (head.right != null) stack.push(head.right);
            if (head.left != null) stack.push(head.left);
        }
    }

    // 中序非递归
    public static void inTravelsal1(Node head) {
        if (head == null) return;

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
    }

    // 后序非递归
    public static void posTravelsal(Node head){
        if(head == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while(!s1.isEmpty()){
            head = s1.pop();
            s2.push(head);
            if(head.left != null) s1.push(head.left);
            if(head.right != null) s2.push(head.right);
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().val + " ");
        }
    }
}
