public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int cur = 0;
        while(num != 0) {
            while(cur < values.length && num < values[cur]) {
                cur++;
            }
        
            sb.append(s[cur]);
            num -= values[cur];
        }
        
        return sb.toString();
    }
}