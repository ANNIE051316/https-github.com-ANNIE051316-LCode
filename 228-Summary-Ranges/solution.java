public class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        int start = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1] + 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[start]);
                if(start != i - 1) {
                    sb.append("->");
                    sb.append(nums[i - 1]);
                }
                res.add(sb.toString());
                start = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(nums[start]);
        if(start != nums.length - 1) {
            sb.append("->");
            sb.append(nums[nums.length - 1]);
        }
        res.add(sb.toString());
        return res;
    }
}