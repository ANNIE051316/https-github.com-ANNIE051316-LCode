public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int s = (nums.length + 1) / 2;
        int t = nums.length;
        
        for(int i = 0; i < nums.length; i++) {
            tmp[i] = ((i & 1) == 0) ? nums[--s] : nums[--t];
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }

        
    }
}