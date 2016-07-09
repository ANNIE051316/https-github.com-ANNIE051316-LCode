public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<String>((n & 1) == 1 ? Arrays.asList("0", "1", "8") : Arrays.asList(""));
        List<String> cur;
        
        for(; n > 1; n -= 2) {
            cur = new ArrayList<String>();
            for(String s : ans) {
                if(n > 3) {
                    cur.add("0" + s + "0");
                }
                cur.add("1" + s + "1");
                cur.add("8" + s + "8");
                cur.add("6" + s + "9");
                cur.add("9" + s + "6");
            }
            
            ans = cur;
        }
        
        return ans;
    }
}