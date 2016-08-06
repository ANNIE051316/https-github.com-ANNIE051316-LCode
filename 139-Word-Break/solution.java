public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        if(wordDict == null || wordDict.size() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<Integer> lenset = new HashSet();

        for(String word : wordDict) {
            lenset.add(word.length());
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int len : lenset) {
                if(i - len >= 0 && dp[i - len] && wordDict.contains(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}