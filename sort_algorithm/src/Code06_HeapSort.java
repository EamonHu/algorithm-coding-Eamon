public class Code06_HeapSort {

    private static void heapSort(int[] arr, int length) {
        build_heap(arr, length);

        for(int i = length - 1; i >= 0; i--){
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private static void build_heap(int[] arr, int length) {
        int last_node = length - 1;
        int parent = (last_node - 1) / 2;
        for(int i = parent; i >= 0; i--){
            heapify(arr, length, i);
        }
    }

    private static void heapify(int[] arr, int len, int index) {
        // 终止条件
        if(index >= len) return;

        // 子节点
        int c1 = index * 2 + 1;
        int c2 = index * 2 + 2;
        int max = index;
        if(c1 < len && arr[c1] > arr[max]) max = c1;
        if(c2 < len && arr[c2] > arr[max]) max = c2;
        if(max != index){
            swap(arr, index, max);
            heapify(arr, len, max);
        }
    }


    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 9, 2, 4, 6, 8, 11, 10};
        heapSort(arr, arr.length);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
