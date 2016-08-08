public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet();
        for(int num : nums) {
            set.add(num);
        }
        int len = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                continue;
            }
            int tmplen = 1;
            set.remove(nums[i]);
            int left = nums[i] - 1;
            while(set.contains(left)) {
                tmplen++;
                set.remove(left);
                left--;
            }
            int right = nums[i] + 1;
            while(set.contains(right)) {
                tmplen++;
                set.remove(right++);
            }
            len = Math.max(len, tmplen);
        }
        
        return len;
    }
}