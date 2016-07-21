public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i : nums) {
            set.add(i);
        }
        
        int res = 0;
        for(int i : nums) {
            if(!set.contains(i)) {
                continue;
            }
            int tmp = 1;
            int j = i - 1;
            while(set.contains(j)) {
                tmp++;
                set.remove(j--);
            }
            j = i + 1;
            while(set.contains(j)) {
                tmp++;
                set.remove(j++);
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}