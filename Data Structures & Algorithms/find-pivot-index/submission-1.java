class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = nums.length - 1; i >= 0; i--){
            total += nums[i];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (sum == (total - sum - nums[i])){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}