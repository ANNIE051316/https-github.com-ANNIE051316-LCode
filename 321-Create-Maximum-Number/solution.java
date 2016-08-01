public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        
        for(int i = Math.min(k, nums1.length); k - i <= nums2.length && i >= 0; i--) {
            int[] n1 = maxArray(nums1, i);
            int[] n2 = maxArray(nums2, k - i);
            int[] tmp = merge(n1, n2);
            if(greater(tmp, 0, res, 0)) {
                res = tmp;
            }
        }
        
        return res;
    }
    
    public int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        if(k == 0) {
            return res;
        }
        
        int pos = 0;
        int i = 0;
        int needed = k;
        while(i < k) {
            for(int j = pos + 1; j <= nums.length - needed; j++) {
                if(nums[j] > nums[pos]) {
                    pos = j;
                }
            }
            needed--;
            res[i++] = nums[pos++];
        }
        return res;
    }
    
    public int[] merge(int[] num1, int[] num2) {
        int[] res = new int[num1.length + num2.length];
        int index = 0;
        int i = 0, j = 0;
        while(index < res.length) {
            res[index++] = greater(num1, i, num2, j) ? num1[i++] : num2[j++];
        }
        return res;
    }
    
    
    public boolean greater(int[] num1, int i1, int[] num2, int i2) {
        while(i1 < num1.length && i2 < num2.length && num1[i1] == num2[i2]) {
            i1++;
            i2++;
        }
        return i2 == num2.length || (i1 < num1.length && num1[i1] > num2[i2]);
    }
    
    
    
}