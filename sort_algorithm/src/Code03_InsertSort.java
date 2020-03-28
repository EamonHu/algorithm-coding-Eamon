public class Code03_InsertSort {


    private static void insertSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
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
        insertSort(arr);
        for(int num: arr){
            System.out.print(num + " ");
        }
    }
}
