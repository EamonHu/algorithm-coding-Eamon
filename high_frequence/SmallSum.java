/**
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
 * <p>
 * <p>
 * 输入：[1, 3, 4, 2, 5]
 * 输出：16
 * <p>
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * <p>
 * 所以小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int sum = smallSum(arr, 0, arr.length - 1);
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println(sum);
    }

    public static int smallSum(int[] arr, int start, int end) {
        if (start == end) return 0;

        int mid = start + (end - start) / 2;
        return smallSum(arr, start, mid) + smallSum(arr, mid + 1, end) + merge(arr, start, mid, end);
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int p1 = start, p2 = mid + 1, index = 0, sum = 0;
        int[] help = new int[end - start + 1];

        while (p1 <= mid && p2 <= end) {
           if (arr[p1] < arr[p2]) {
                sum += (end - p2 + 1) * arr[p1];
                help[index++] = arr[p1++];

            } else {
                help[index++] = arr[p2++];
            }
        }

        while (p1 <= mid) help[index++] = arr[p1++];
        while (p2 <= end) help[index++] = arr[p2++];

        if (help.length > 0) System.arraycopy(help, 0, arr, start, help.length);
        return sum;
    }


    /**
     * 暴力解法
     *
     * @param arr
     * @return
     */
    public static int smallSum_violence(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }
}
