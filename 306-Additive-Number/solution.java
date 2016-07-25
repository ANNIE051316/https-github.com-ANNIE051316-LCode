public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3) {
            return false;
        }
        
        int len = num.length();
        for(int i = 1; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                String num1 = num.substring(0, i);
                String num2 = num.substring(i, j);
                if(isValid(num1, num2, num, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isValid(String num1, String num2, String num, int cur) {
        if(cur >= num.length()) {
            return true;
        }
        
        if(num1.length() > 1 && num1.charAt(0) == '0' || num2.length() > 1 &&  num2.charAt(0) == '0') {
            return false;
        }
        
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
        String n3 = String.valueOf(n1 + n2);
        if(cur + n3.length() <= num.length() && n3.equals(num.substring(cur, cur + n3.length()))) {
            return isValid(num2, n3, num, cur + n3.length());
        }
        return false;
    }
}