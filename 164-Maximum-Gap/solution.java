public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int gap = (int)Math.ceil(((double)(max - min)) / (nums.length - 1));
        int[] mins = new int[nums.length];
        Arrays.fill(mins, Integer.MAX_VALUE);
        int[] maxs = new int[nums.length];
        Arrays.fill(maxs, Integer.MIN_VALUE);
        
        for(int num : nums) {
            int index = (num - min) / gap - 1;
            maxs[index] = Math.max(maxs[index], num);
            mins[index] = Math.min(mins[index], num);
        }
        
        int res = 0;
        int prevmax = maxs[0];
        for(int i = 0; i < nums.length; i++) {
                if(maxs[i] != Integer.MIN_VALUE) {
                    res = Math.max(res, Math.max(maxs[i] - mins[i], mins[i] - prevmax));
                    prevmax = maxs[i];
                }
        }
        
        return res;
        
    }
}