public class IsBalanceOfTree {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int data) {
            this.val = data;
        }
    }

    public static Boolean isBalanceTree(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    private static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) return level;

        // 左子树
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) return level;

        // 右子树
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) return level;

        if (Math.abs(lH - rH) > 1) res[0] = false;

        return Math.max(lH, rH);
    }
}
