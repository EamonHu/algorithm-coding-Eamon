import java.util.HashSet;

public class Offer23_EntryNodeOfLoop {

    public ListNode entryNodeOfLoop_HashSet(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;

        HashSet<ListNode> hashSet = new HashSet<ListNode>();
        while (pHead != null) {
            if (hashSet.contains(pHead)) {
                return pHead;
            }
            hashSet.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    public ListNode entryNodeOfLoop_FastSlow(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) return null;

        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
