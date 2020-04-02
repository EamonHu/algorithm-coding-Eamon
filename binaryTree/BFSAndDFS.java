import java.util.*;

public class BFSAndDFS {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 使用队列层次遍历二叉树
    public static List<Integer> BFSByQueue(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //存放遍历结果，然后返回
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            /*
            处理 TreeNode 节点 的逻辑
             */
            result.add(treeNode.val);


            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return result;
    }

    // 使用栈深度遍历
    public static List<Integer> DFSByStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();

            /*
            处理 TreeNode 节点 的逻辑
             */
            result.add(treeNode.val);

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }

        }
        return result;
    }


}
