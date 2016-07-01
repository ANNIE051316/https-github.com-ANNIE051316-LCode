public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] res = new int[nums.length];
        int index = a >= 0 ? nums.length - 1 : 0;
        
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int t1 = a * nums[i] * nums[i] + b * nums[i] + c;
            int t2 = a * nums[j] * nums[j] + b * nums[j] + c;
            if(a >= 0) {
                if(t1 >= t2) {
                    res[index] = t1;
                    i++;
                }
                else {
                    res[index] = t2;
                    j--;
                }
            }
            else {
                if(t1 <= t2) {
                    res[index] = t1;
                    i++;
                }
                else {
                    res[index] = t2; 
                    j--;
                }
            }
            index += (a >= 0 ? -1 : 1);
        }
        
        return res;
    }
}