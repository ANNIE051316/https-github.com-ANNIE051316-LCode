public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m + n - 1, j = n - 1, k = m - 1; j >= 0 && i >= 0; i--) {
            if(k < 0 || nums2[j] >= nums1[k]) {
                nums1[i] = nums2[j--];
            }
            else {
                nums1[i] = nums2[k--];
            }
        }
    }
}