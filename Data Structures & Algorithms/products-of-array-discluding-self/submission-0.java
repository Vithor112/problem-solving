class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length]; 
        int[] prefix = new int[nums.length];
        int [] postfix = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++){
            product *= nums[i];
            prefix[i] = product;
        }
        product = 1;
        for (int i =  nums.length - 1; i >= 0; i--){
            product *= nums[i];
            postfix[i] = product;
        }
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && i < nums.length - 1){
            output[i] = prefix[i - 1] * postfix[i + 1];
            } else if (i == 0){
                output[i] = postfix[i+1];
            } else if (i == nums.length - 1) {
                output[i] = prefix[i - 1];
            }
        }
        return output;
    }
}  