class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.val = data;
    }
}

public class Offer7_RebuildBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = helper(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = helper(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return root;
    }
}
