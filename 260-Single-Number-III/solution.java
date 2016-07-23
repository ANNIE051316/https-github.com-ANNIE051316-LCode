public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length <2) {
            return new int[0];
        }
        
        int[] res = new int[2];
        
        int xor = 0;
        for(int n : nums) {
            xor = xor ^ n;
        }
        int rightbit = xor & (-xor);
        
        int lxor = xor;
        for(int n : nums) {
            if((rightbit & n) > 0) {
                xor = xor ^ n;
            }
            else {
                lxor = lxor ^ n;
            }
        }
        
        res[0] = lxor;
        res[1] = xor;
        return res;
    }
}