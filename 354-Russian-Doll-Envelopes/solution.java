public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override 
            public int compare(int[] e1, int[] e2) {
                return e1[0] - e2[0];
            }
        });
        
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}