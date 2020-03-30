class Node{
    public int val;
    public Node next;
    public Node(int data){
        this.val = data;
    }
}

public class Offer24_ReverseList {

    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head!= null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head){
        System.out.print("Lined List:");
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reverseList(head);
        printLinkedList(head);
    }

}
