class Solution {
    public int pivotIndex(int[] nums) {
        int[] postFixSum = new int[nums.length]; 
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--){
            postFixSum[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (sum == postFixSum[i]){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}