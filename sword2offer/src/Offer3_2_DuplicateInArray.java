public class Offer3_2_DuplicateInArray {

    public static Integer findDuplicateInArray(int[] a){
        int[] newA = new int[a.length];

        for (int temp : a) {
            if (newA[temp] == temp) return temp;
            newA[temp] = temp;
        }
        return -1;
    }

    public static Integer findDuplicateInArray2(int[] a){
        if(a == null || a.length <= 0) return -1;

        int start = 1;
        int end = a.length - 1;
        while(start <= end){
            int mid = start + (end - start) >> 2;
            int count = countRange(a, start, mid);
            if(end == start){
                if(count > 1) return start;
                else break;
            }
            if(count > mid - start + 1) end = mid;
            else start = mid + 1;
        }
        return -1;
    }

    private static int countRange(int[] a, int start, int end) {
        int count = 0;
        if(a == null) return count;

        for (int value : a) {
            if (value >= start && value <= end) {
                ++count;
            }
        }
        return count;


    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(findDuplicateInArray2(a));
    }
}
