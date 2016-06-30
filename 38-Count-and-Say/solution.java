public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder("1");
        for(int i = 1; i < n; i++) {
            int sz = sb.length();
            StringBuilder tmp = new StringBuilder();
            char c = sb.charAt(0);
            int count = 1;
            for(int j = 1; j < sz; j++) {
                char t = sb.charAt(j);
                if(c == t) {
                    count++;
                }
                if(c != t) {
                    tmp.append(count);
                    tmp.append(c);
                    c = t;
                    count = 1;
                }
            }
         
            tmp.append(count);
               tmp.append(c);
            
            sb = tmp;
        }
        
        return sb.toString();
    }
}