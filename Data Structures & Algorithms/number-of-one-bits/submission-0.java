class Solution {
    public int hammingWeight(int n) {
        int sumOfBits = 0;
        while (n != 0){
            sumOfBits += n % 2; 
            n = n/2; 
        }
        return sumOfBits;
    }
}
