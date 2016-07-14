public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        PriorityQueue<int[]> minheap = new PriorityQueue<int[]>(11, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return (p1[0] + p1[1] - p2[0] - p2[1]);
            }
        });
        
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                minheap.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        
        while(k > 0 && !minheap.isEmpty()) {
            res.add(minheap.poll());
            k--;
        }
        return res;
    }
}