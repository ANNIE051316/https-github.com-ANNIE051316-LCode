public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        }
        
        if(b == null || b.length() == 0) {
            return a;
        }
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        while(i >= 0 || j >= 0) {
            char c1 = (i < 0 ?  '0' : a.charAt(i));
            char c2 = (j < 0 ?  '0' : b.charAt(j));
            carry += c1 - '0' + c2 - '0';
            sb.insert(0, carry % 2);
            carry /= 2;
            i--;
            j--;
        }
        
        if(carry != 0) {
            sb.insert(0, carry);
        }
        
        return sb.toString();
        
    }
}