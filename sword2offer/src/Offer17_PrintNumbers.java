public class Offer17_PrintNumbers {
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10,n) - 1;
        int[] res = new int[max];
        int i = 1;
        while(i <= max){
            res[i-1] = i;
            i++;
        }
        return res;
    }
}
