public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        int[] parents = new int[nums.length];
        int[] len = new int[nums.length];
        
        Arrays.sort(nums);
        int maxindex = 0;
        int maxlen = 1;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                len[i] = 1;
                continue;
            }
            parents[i] = i;
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(len[j]  > max && nums[i] % nums[j] == 0) {
                    parents[i] = j;
                    max = len[j];
                }
            }
            len[i] = max + 1;
            if(len[i] > maxlen) {
                maxindex = i;
                maxlen = len[i];
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while(maxlen > 0) {
            res.add(0, nums[maxindex]);
            maxindex = parents[maxindex];
            maxlen--;
        }
        
        return res;
    }
}