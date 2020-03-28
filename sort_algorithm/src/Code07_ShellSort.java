public class Code07_ShellSort {

    private static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j >= gap && arr[j - gap] > arr[j]; j -= gap) {
                    swap(arr, j, j - gap);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 9, 2, 4, 6, 8, 11, 10};
        shellSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
