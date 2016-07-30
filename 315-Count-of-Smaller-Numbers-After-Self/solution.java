public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<Integer>();
        List<Integer> res = new ArrayList();
        for(int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            res.add(0, index);
        }
        return res;
    }
    
    public int findIndex(List<Integer> sorted, int num) {
        int left = 0, right = sorted.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(sorted.get(mid) >= num) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        sorted.add(left, num);
        return left;
    }
}