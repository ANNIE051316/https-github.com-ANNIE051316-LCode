public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0) {
            return num2;
        }
        
        if(num2 == null || num2.length() == 0) {
            return num1;
        }
        
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        int carry = 0;
        
        for(int i = m - 1; i >= 0; i--) {
            char c = num1.charAt(i);
            for(int j = n - 1; j >= 0; j--) {
                char t = num2.charAt(j);
                int mul = (c - '0') * (t - '0');
                int p1 = i + j, p2 = i + j + 1;
                mul += pos[p2];
                pos[p2] = mul % 10;
                pos[p1] += mul / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pos.length; i++) {
            if(sb.length() == 0 && pos[i] == 0) {
                continue;
            }
            sb.append(pos[i]);
        }
        
        return sb.length() == 0 ?  "0" : sb.toString();
    }
}