public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() <= 1) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        
        for(int i = 1; i <= len; i++) {
            int min = dp[i - 1]  + 1;
            for(int j = 1; j <= i; j++) {
                if(dp[j - 1] + 1 < min && isValid(s.substring(j - 1, i))) {
                    min = dp[j - 1] + 1;
                } 
            }
            dp[i] = min;
        }
        
        return dp[len] - 1;
    }
    
    public boolean isValid(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
}