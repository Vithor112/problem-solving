class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length]; 
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++){
            if (dp[i] == 1){
                for (int j = i + 1; j < nums.length && j <= i + nums[i]; j++){
                    dp[j] = 1; 
                }
            }
        }
        return dp[dp.length - 1] == 1;
    }
}
