public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n <= 0) {
            return;
        }
        int index = m + n - 1;
        int i2 = n - 1;
        int i1 = m - 1;
        while(i2 >= 0) {
            if(i1 < 0 || nums2[i2] >= nums1[i1]) {
                nums1[index--] = nums2[i2--];
            }
            else {
                nums1[index--] = nums1[i1--];
            }
        }
        
        
    }
}