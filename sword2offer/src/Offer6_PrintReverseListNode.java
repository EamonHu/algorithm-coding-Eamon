import java.util.ArrayList;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x;}

    // 添加新的结点
    public void add(int newval) {
        ListNode newNode = new ListNode(newval);
        if(this.next == null)
            this.next = newNode;
        else
            this.next.add(newval);
    }
    // 打印链表
    public void print() {
        System.out.print(this.val);
        if(this.next != null)
        {
            System.out.print("-->");
            this.next.print();
        }
    }
}


class Offer_6PrintReverseListNode {
    private static int[] reversePrint(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        if(head != null){
            if(head.next != null){
                reversePrint(head.next);
            }
            res.add(head.val);
        }
        int[] print = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            print[i] = res.get(i);
        }
        return print;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(3);
        head.add(2);
        int[] res = reversePrint(head);
        for(int num : res){
            System.out.println(num);
        }

    }
}
