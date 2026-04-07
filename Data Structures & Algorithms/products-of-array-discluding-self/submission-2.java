class Solution {
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    
    // Step 1: Calculate prefix products and store in res
    // res[i] will contain the product of all elements to the left of i
    res[0] = 1;
    for (int i = 1; i < n; i++) {
        res[i] = res[i - 1] * nums[i - 1];
    }
    
    // Step 2: Calculate postfix products on the fly
    // Multiply the current prefix product by the running postfix product
    int postfix = 1;
    for (int i = n - 1; i >= 0; i--) {
        res[i] *= postfix;
        postfix *= nums[i];
    }
    
    return res;
}
}  