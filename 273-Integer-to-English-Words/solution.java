public class Solution {
    public String numberToWords(int num) {
        String[] thousands = new String[]{"Thousand", "Million", "Billion"};
        String[] tens = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ones = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        StringBuilder sb = new StringBuilder();
        int cur = -1;
        while(num != 0) {
            StringBuilder temp = new StringBuilder();
            int tmp = num % 1000;
            if(tmp / 100 != 0) {
                temp.append(ones[tmp / 100] + " ");
                temp.append("Hundred" + " ");
            }
            tmp %= 100;
            if(tmp >= 20) {
                temp.append(tens[tmp / 10 - 2] + " ");
                tmp %= 10;
            }
            
            if(tmp != 0) {
                temp.append(ones[tmp] + " ");
            }
            
            if(cur >= 0 && temp.length() != 0) {
                temp.append(thousands[cur] + " ");
            }
            
            if(temp.length() != 0) {
                sb.insert(0, temp);
            }
            cur++;
            num = num / 1000;
        }
        
        return sb.length() == 0 ? "Zero" : sb.toString().trim();
        
        
    }
}