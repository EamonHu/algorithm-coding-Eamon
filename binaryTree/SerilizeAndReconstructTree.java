import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerilizeAndReconstructTree {

    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int data){
            this.val = data;
        }
    }

    // 序列化：前序递归
    public static String serialByPre(Node head){
        if(head == null) return "#_";
        String res = head.val + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.offer(value);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if(Objects.equals(value, "#")) return null;

        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
