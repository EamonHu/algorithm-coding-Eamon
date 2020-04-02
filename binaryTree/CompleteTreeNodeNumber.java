public class CompleteTreeNodeNumber {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int data) {
            this.val = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) return 0;

        return bs(head, 1, heightOfTree(head, 1));
    }

    /**
     * @param node  当前节点
     * @param level 层次
     * @param h     整棵树的高度
     * @return 树的所有节点数量
     */
    public static int bs(Node node, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (heightOfTree(node.right, level + 1) == h) {
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            return (1 << (h - level - 1) + bs(node.left, level + 1, h));
        }
    }

    private static int heightOfTree(Node head, int level) {
        while (head != null) {
            level++;
            head = head.left;
        }
        return level - 1;
    }
}
