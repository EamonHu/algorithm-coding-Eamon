public class offer3_1_duplicate {
    // 1.暴力法
    public int findRepeatNumber(int[] nums) {
        if(nums.length < 2) return -1;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]) return nums[i];
            }
        }
        return -1;
    }

    // 2.哈希表
    // 3.置换

    public void main(String[] args) {
        int[] a = new int[]{3,1,2,3};
        int repeatNumber = findRepeatNumber(a);
        System.out.println(repeatNumber);
    }
}
