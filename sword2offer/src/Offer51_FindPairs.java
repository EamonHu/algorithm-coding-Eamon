public class Offer51_FindPairs {

    private static int findPairs(int[] arr, int start, int end) {
        if (arr == null || arr.length < 2 || start == end) return 0;

        int mid = start + (end - start) / 2;
        return findPairs(arr, start, mid) + findPairs(arr, mid + 1, end) +
                merge(arr, start, mid, end);

    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int[] help = new int[end - start + 1];
        int p1 = start, p2 = mid + 1, index = 0, count = 0;
        while (p1 <= mid && p2 <= end) {
            count += arr[p1] > arr[p2] ? (end - p2 + 1) : 0;
            help[index++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) help[index++] = arr[p1++];
        while (p2 <= end) help[index++] = arr[p2++];

        if (help.length > 0) System.arraycopy(help, 0, arr, start, help.length);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        int pairs = findPairs(arr, 0, arr.length - 1);
        System.out.println(pairs);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}