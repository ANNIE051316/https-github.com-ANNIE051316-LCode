public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if( k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("");
        }
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}