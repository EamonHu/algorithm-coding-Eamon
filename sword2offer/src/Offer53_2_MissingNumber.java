public class Offer52_2_MissingNumber {

    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(nums[mid] != mid) j = mid -1;
            else i = mid + 1;
        }
        return i;
    }
}
