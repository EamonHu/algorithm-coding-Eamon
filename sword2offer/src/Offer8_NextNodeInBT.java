class Node8{
    int val;
    Node8 left;
    Node8 right;
    Node8 parent;

    public Node8(int data){
        this.val = data;
    }
}

/**
 * 查找二叉树中的下一个节点
 * 1.有右子树
 * 2.没有右子树
 */
public class Offer8_NextNodeInBT {
    public Node8 getNextNode(Node8 node){
        if(node == null) return null;
        // 1.有右子树
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }

        // 2.没有右子树
        while(node.parent != null){
            if(node.parent.left == node){
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }

}
