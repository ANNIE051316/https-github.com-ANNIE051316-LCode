public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(11, new Comparator<int[]>() {
            @Override
            public int compare(int[] n1, int[] n2) {
                return n1[2] - n2[2];
            }
        });
        
        for(int j = 0; j < matrix[0].length; j++) {
            heap.offer(new int[]{0, j, matrix[0][j]});
        }
        
        while(k > 1) {
            int[] min = heap.poll();
            if(min[0] < matrix.length - 1) {
                heap.offer(new int[]{min[0] + 1, min[1], matrix[min[0] + 1][min[1]]});
            }
            k--;
        }
        
        return heap.poll()[2];
    }
}