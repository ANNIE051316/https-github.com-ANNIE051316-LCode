public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = -1; (i = s.indexOf("++", i + 1)) >= 0;) {
            res.add(s.substring(0, i) + "--" + s.substring(i + 2));
        }
        
        return res;
    }
}