public class Offer26_IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;

        boolean flag = false;
        if (A.val == B.val) {
            flag = hasSub(A, B);
        }
        if (!flag) {
            flag = isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        return flag;
    }

    public boolean hasSub(TreeNode r1, TreeNode r2) {
        if (r2 == null) return true;
        if (r1 == null) return false;
        if (r1.val != r2.val) return false;
        return hasSub(r1.left, r2.left) && hasSub(r1.right, r2.right);
    }
}
