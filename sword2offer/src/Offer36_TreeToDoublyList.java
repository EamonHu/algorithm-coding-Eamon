public class Offer36_TreeToDoublyList {

    Node head = null;
    Node realHead = null;

    public Node Convert(Node pRootOfTree) {
        if (pRootOfTree == null) return null;

        Convert(pRootOfTree.left);

        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }

        Convert(pRootOfTree.right);

        return realHead;
    }
}
