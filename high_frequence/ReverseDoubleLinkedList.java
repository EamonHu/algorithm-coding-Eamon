public class ReverseDoubleLinkedList {

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List:");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
        head.next = new DoubleNode(2);
        head.next.last = head;
        head.next.next = new DoubleNode(3);
        head.next.next.last = head.next;
        head.next.next.next = new DoubleNode(4);
        head.next.next.next.last = head.next.next;
        printDoubleLinkedList(head);
        printDoubleLinkedList(reverseList(head));
    }
}
