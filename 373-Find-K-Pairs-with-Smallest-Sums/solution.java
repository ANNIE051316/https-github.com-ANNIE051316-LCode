public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        int[] indexs = new int[nums1.length];
        
        k = Math.min(k, nums1.length * nums2.length);
        
        while(k > 0) {
            int min = Integer.MAX_VALUE;
            int t = -1;
            for(int i = 0; i < nums1.length; i++) {
                if(indexs[i] < nums2.length && nums2[indexs[i]] + nums1[i] < min) {
                    t = i;
                    min = nums2[indexs[i]] + nums1[i];
                }
            }
            
            res.add(new int[]{nums1[t], nums2[indexs[t]]});
            indexs[t]++;
            k--;
        }
        
        return res;
    }
}