public class Code02_SelectSort {

    private static void selectSort(int[] arr){
        if(arr == null || arr.length < 2) return;

        for(int i = 0; i< arr.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]) min = j;
            }
            if(min != i){
                swap(arr, min, i);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 9, 2, 4, 6, 8, 4, 10};
        selectSort(arr);
        for(int num: arr){
            System.out.print(num + " ");
        }
    }
}
