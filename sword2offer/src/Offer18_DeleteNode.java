public class Offer18_DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val == val) {
                cur.next = next.next;
                break;
            }
            cur = cur.next;
            next = next.next;
        }
        return head;
    }
}
