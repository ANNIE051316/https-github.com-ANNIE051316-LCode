public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        
        backtrack(word, 0, "", 0, res);
        return res;
    }
    
    
    public void backtrack(String word, int pos, String cur, int count, List<String> res) {
        if(pos == word.length()) {
            if(count > 0) {
                cur = cur + count;
            }
            res.add(cur);
            return;
        }
        
        backtrack(word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0, res);
        backtrack(word, pos + 1, cur, count + 1, res);
        
    }
    
}