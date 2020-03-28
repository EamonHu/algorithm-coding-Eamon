public class Offer21_ReOrderArray {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,8,9,2,4,10};
        reOrderArray(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    public static void reOrderArray(int [] a) {
        if(a == null || a.length < 2) return;

        int i = 0;
        while(i < a.length){
            while(i < a.length && a[i] % 2 == 1){
                i++;
            }
            int j = i + 1;
            while( j < a.length && a[j] % 2 == 0){
                j++;
            }
            if(j < a.length){
                int temp = a[j];
                for(int j2 = j - 1; j2 >= i; j2--){
                    a[j2+1] = a[j2];
                }
                a[i++] = temp;
            }else{
                break;
            }
        }
    }
}
