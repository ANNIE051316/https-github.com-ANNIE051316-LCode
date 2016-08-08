public class Solution {
    public String numberToWords(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("Input is negative " + num);
        }
        
        String[] lessthan20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = new String[]{"", "Thousand", "Million", "Billion", "Trillion"};
        
        StringBuilder sb = new StringBuilder();
        int thindex = 0;
        
        while(num != 0) {
            StringBuilder tmp = new StringBuilder();
            int curnum = num % 1000;
            if(curnum / 100 != 0) {
                tmp.append(lessthan20[curnum / 100] + " Hundred");
            }
            curnum %= 100;
            
            if(curnum < 20 ) {
                if(tmp.length() > 0 && curnum != 0) {
                    tmp.append(" ");
                }
                tmp.append(lessthan20[curnum]);
            }
            else {
                if(tmp.length() > 0) {
                    tmp.append(" ");
                }
                
                tmp.append(tens[curnum / 10]);
                if(curnum % 10 > 0) {
                    tmp.append(" " + lessthan20[curnum % 10]);
                } 
            }
            if(tmp.length() > 0 && thindex > 0) {
                tmp.append(" " + thousands[thindex]);    
            }
            if(tmp.length() > 0) {
                if(sb.length() > 0) {
                    tmp.append(" ");
                }
                sb.insert(0, tmp);
            }
            num /= 1000;
            thindex++;
        }
        
        return sb.length() == 0 ? "Zero" : sb.toString();
     }
}