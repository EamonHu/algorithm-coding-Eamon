public class Code08_CountSort {

    private static void countSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(max, num);
        }

        int[] help = new int[max + 1];

        for (int num : arr) {
            help[num]++;
        }

        int i = 0;
        for(int j = 0; j < help.length; j++){
            while(help[j]-- > 0){
                arr[i++] = j;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 9, 2, 4, 6, 8, 11, 10};
        countSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }



    public static int[] CountSortPro(int[] arr){
        // 1.求最大值和最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a : arr){
            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        // 2.得到统计数组
        int[] bucket = new int[max - min + 1];

        for(int num: arr){
            bucket[num - min]++;
        }

        // 3.统计数组变形
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += bucket[i];
            bucket[i] = sum;
        }

        // 4.倒叙遍历原数组，从统计数组中找到对应位置，输出结果数组
        int[] sortedArray = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            sortedArray[bucket[arr[i] - min] - 1] = arr[i];
            bucket[arr[i] - min]--;
        }
        return sortedArray;
    }
}
