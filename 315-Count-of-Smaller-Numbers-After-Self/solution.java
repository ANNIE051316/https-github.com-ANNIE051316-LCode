public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
        
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
        }
        
        int[] bit = new int[nums.length];
        
        for(int i = nums.length - 1; i >= 0; i--) {
            int count = getSum(bit, nums[i] - 1);
            res.add(0, count);
            update(bit, nums[i]);
        }
        return res;
    }
    
    public int getSum(int[] bit, int i) {
        int res = 0;
        
        while(i > 0) {
            res += bit[i - 1];
            i = i - (i & (-i));
        }
        return res;
    }
    
    public void update(int[] bit, int i) {
        while(i <= bit.length) {
            bit[i - 1]++;
            i = i + (i & (-i));
        }
    }
}