public class Code05_MergeSort {

    private static void mergeSort(int[] arr, int start, int end) {
        if (arr == null || arr.length < 2 || start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int p1 = start, p2 = mid + 1, index = 0;
        int[] helper = new int[end - start + 1];

        while (p1 <= mid && p2 <= end) {
            helper[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) helper[index++] = arr[p1++];
        while (p2 <= end) helper[index++] = arr[p2++];

        System.arraycopy(helper, 0, arr, start, helper.length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 9, 2, 4, 6, 8, 11, 10};
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }


}
