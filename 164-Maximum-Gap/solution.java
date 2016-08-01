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
        int[] mins = new int[nums.length - 1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        int[] maxs = new int[nums.length - 1];
        Arrays.fill(maxs, Integer.MIN_VALUE);
        
        for(int num : nums) {
            if(num == min || num == max) {
                continue;
            }
            int index = (num - min) / gap;
            maxs[index] = Math.max(maxs[index], num);
            mins[index] = Math.min(mins[index], num);
        }
        
        int res = 0;
        int prevmax = min;
        for(int i = 0; i < maxs.length; i++) {
                if(maxs[i] != Integer.MIN_VALUE) {
                    res = Math.max(res, Math.max(maxs[i] - mins[i], mins[i] - prevmax));
                    prevmax = maxs[i];
                }
        }
        
        res = Math.max(res, max - prevmax);
        return res;
        
    }
}