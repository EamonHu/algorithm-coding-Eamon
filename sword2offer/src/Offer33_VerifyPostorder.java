public class Offer33_VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return isPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean isPostorder(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;

        int m = p;
        while (postorder[p] > postorder[j]) p++;

        return p == j && isPostorder(postorder, i, m - 1) && isPostorder(postorder, m, j - 1);
    }
}
