public class Solution {
    class Pair{
        int index;
        int val;
        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Integer[] counts = new Integer[nums.length];
        List<Pair> pairs = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            pairs.add(new Pair(i, nums[i]));
            counts[i] = 0;
        }
        
        mergeSort(pairs, counts);
        
        res.addAll(Arrays.asList(counts));
        return res;
    }
    
    public List<Pair> mergeSort(List<Pair> pairs, Integer[] counts) {
        if(pairs.size() <= 1) {
            return pairs;
        }
        int mid = pairs.size() / 2;
        
        List<Pair> left = mergeSort(pairs.subList(0, mid), counts);
        List<Pair> right = mergeSort(pairs.subList(mid, pairs.size()), counts);
        List<Pair> merged = new ArrayList<Pair>();
        for(int i = 0, j = 0; i < left.size() || j < right.size();) {
            if(j == right.size() || (i < left.size() && left.get(i).val <= right.get(j).val)) {
                counts[left.get(i).index] += j;
                merged.add(left.get(i));
                i++;
            }
            else {
                merged.add(right.get(j));
                j++;
            }
        }
        
        return merged;
    }
}