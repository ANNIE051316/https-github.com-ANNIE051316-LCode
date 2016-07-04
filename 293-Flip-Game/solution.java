public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null) {
            return res;
        }
        
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == '-' || chars[i + 1] == '-') {
                continue;
            }
            
            chars[i] = '-';
            chars[i + 1] = '-';
            res.add(String.valueOf(chars));
            chars[i] = '+';
            chars[i + 1] = '+';
        }
        
        return res;
    }
}