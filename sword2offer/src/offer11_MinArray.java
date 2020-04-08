public class offer11_MinArray {
    public int minArray(int[] numbers){
        if(numbers == null || numbers.length == 0) return -1;

        int low = 0, high = numbers.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(numbers[mid] > numbers[high]){
                low = mid + 1;
            }else if(numbers[mid] == numbers[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return numbers[low];
    }
}
