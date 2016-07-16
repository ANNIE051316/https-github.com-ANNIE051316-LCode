public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int e2[]) {
                if(e1[0] == e2[0]) {
                    return e2[1] - e1[1];
                }
                return e1[0] - e2[0];
            }
        });
        
        int len = 1;
        int[] sorted = new int[envelopes.length];
        sorted[0] = envelopes[0][1];
        
        for(int i = 1; i < envelopes.length; i++) {
            if(envelopes[i][1] > sorted[len - 1]) {
                sorted[len++] = envelopes[i][1];
            }
            else {
                int pos = find(sorted, 0, len - 1, envelopes[i][1]);
                sorted[pos] = envelopes[i][1];
            }
        }
        
        return len;
    }
    
    public int find(int[] sorted, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(sorted[mid] == target) {
                return mid;
            }
            else if(sorted[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
}