public class Offer5_2_MergeArray {

    public static void mergeArray(int[] a, int[] b, int aLen, int bLen) {
        int i = aLen - 1;
        int j = bLen - 1;
        int index = aLen + bLen - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] >= b[j]) {
                a[index--] = a[i--];
            } else {
                a[index--] = b[j--];
            }
        }
        while (i >= 0) a[index--] = a[i--];
        while (j >= 0) a[index--] = b[j--];
    }

    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = {2, 4, 6, 7};
        a1[0] = 1;
        a1[1] = 3;
        a1[2] = 5;
        a1[3] = 6;
        mergeArray(a1, a2, 4, 4);
        for (int num : a1) {
            System.out.print(num + " ");
        }
    }
}
