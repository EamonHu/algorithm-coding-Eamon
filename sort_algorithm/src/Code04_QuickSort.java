public class Code04_QuickSort {

    private static void quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length < 2 || start > end) return;

        swap(arr, start + (int) (Math.random() * (end - start + 1)), start);
        int p1 = start, p2 = end, base = arr[start];

        while (p1 < p2) {
            while (p1 < p2 && arr[p2] >= base) p2--;
            while (p1 < p2 && arr[p1] <= base) p1++;
            swap(arr, p1, p2);
        }
        arr[start] = arr[p1];
        arr[p1] = base;

        quickSort(arr, start, p1 - 1);
        quickSort(arr, p1 + 1, end);
    }


    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 9, 2, 4, 6, 8, 11, 10};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
