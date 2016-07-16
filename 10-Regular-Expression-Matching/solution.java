public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();
        for(int i = 0; i <= slen; i++) {
            for(int j = 1; j <= plen; j++) {
                if(pchar[j - 1] != '*') {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (pchar[j - 1] == '.' || pchar[j - 1] == schar[i - 1]);
                }
                else {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && dp[i - 1][j] && (schar[i - 1] == pchar[j - 2] || pchar[j - 2] == '.'));
                }
            }
         }
         
         return dp[slen][plen];
    }
}