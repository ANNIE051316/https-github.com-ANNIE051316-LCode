public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < nums.length && lower <= upper; i++) {
            if(nums[i] != lower) {
                addInterval(res, lower, nums[i] - 1);
            }
            lower = nums[i] + 1;  
        }
        
        if(lower <= upper) {
            addInterval(res, lower, upper);
        }
        
        return res;
    }
    
    public void addInterval(List<String> res, int lower, int upper) {
        StringBuilder sb = new StringBuilder();
        sb.append(lower);
        if(upper != lower){
            sb.append("->" + upper);
        }
        
        res.add(sb.toString());
    }
}