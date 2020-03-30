public class PrintCommonPart {
    public static class Node {
        int val;
        Node next;

        Node(int data) {
            this.val = data;
        }
    }

    static void printCommonPart(Node h1, Node h2) {
        System.out.println("Common Part: ");
        while(h1 != null && h2!= null){
            if(h1.val < h2.val){
                h1 = h1.next;
            }else if(h2.val < h1.val){
                h2 = h2.next;
            }else {
                System.out.print(h1.val + " ");
                h1 = h1.next;
                h2 = h2.next;
            }
        }

    }

    private static void printLinkedList(Node node) {
        System.out.println("Linked list: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node h1 = new Node(2);
        h1.next = new Node(3);
        h1.next.next = new Node(5);
        h1.next.next.next = new Node(6);

        Node h2 = new Node(1);
        h2.next = new Node(2);
        h2.next.next = new Node(5);
        h2.next.next.next = new Node(7);
        h2.next.next.next.next = new Node(8);

        printLinkedList(h1);
        printLinkedList(h2);
        printCommonPart(h1, h2);
    }

}
