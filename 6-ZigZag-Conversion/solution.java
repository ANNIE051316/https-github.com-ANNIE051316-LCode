public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1) {
            return s;
        }
        if(numRows <= 0) {
            throw new IllegalArgumentException("input numRows invalid: " + numRows);
        }
        
        int group = numRows * 2 - 2;
        
        int len = s.length();
        StringBuilder sb  = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            int index1 = i;
            int index2 = group - i;
            while(index1 < len) {
                sb.append(s.charAt(index1));
                index1 += group;
                if(i != 0 && i != numRows - 1 &&  index2 < len) {
                    sb.append(s.charAt(index2));
                    index2 += group;
                } 
            }
        }
        
        return sb.toString();
        
    }
}