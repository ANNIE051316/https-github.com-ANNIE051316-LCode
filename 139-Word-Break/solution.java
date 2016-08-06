public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        if(wordDict == null || wordDict.size() == 0) {
            return false;
        }
        
        Set<Integer> lenset = new HashSet();
        for(String word : wordDict) {
            lenset.add(word.length());
        }
        
        return helper(s, 0, wordDict, lenset);
    }
    
    public boolean helper(String s, int start, Set<String> wordDict, Set<Integer> lenset) {
        if(start == s.length()) {
            return true;
        }
        
        for(int len : lenset) {
            if(len + start > s.length()) {
                continue;
            }
            String sub = s.substring(start, start + len);
            if(wordDict.contains(sub) && helper(s, start + len, wordDict, lenset)) {
                return true;
            }
        }
        
        return false;
    }
    
}