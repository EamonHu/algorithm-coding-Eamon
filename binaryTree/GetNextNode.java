public class GetNextNode {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node parent;

        public Node(int data){
            this.val = data;
        }
    }

    public Node getNextNode(Node node){
        if(node == null) return null;

        // 有右子树
        if(node.right != null){
            while(node.left != null){
                node = node.left;
            }
            return node;
        }

        // 没有右子树
        while(node.parent != null){
            if(node.parent.left == node) return node.parent;
            node = node.parent;
        }
        return null;
    }
}
