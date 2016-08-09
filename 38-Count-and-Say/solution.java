public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for(int i = 2; i <= n; i++) {
            StringBuilder tmp = new StringBuilder();
            char c = sb.charAt(0);
            int count = 1;
            for(int j = 1; j < sb.length(); j++) {
                char t = sb.charAt(j);
                if(c == t) {
                    count++;
                    continue;
                }
                tmp.append(count);
                tmp.append(c);
                c = t;
                count = 1;
            }
            tmp.append(count);
            tmp.append(c);
            sb = tmp;
        }
        return sb.toString();
    }
}