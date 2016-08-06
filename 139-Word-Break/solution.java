public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        if(wordDict == null || wordDict.size() == 0) {
            return false;
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        
        Set<Integer> lenset = new HashSet();
        for(String word : wordDict) {
            lenset.add(word.length());
        }
        
        dp[0] = true;
        for(int i = 0; i < s.length(); i++) {
            for(int len : lenset) {
                if(i - len + 1 >= 0 && dp[i - len + 1] && wordDict.contains(s.substring(i - len + 1, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
     }
}