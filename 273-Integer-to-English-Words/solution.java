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
            if(num % 1000 != 0) {
                String tmp = helper(num % 1000, tens, lessthan20);
                tmp = tmp + thousands[thindex] + " ";
                sb.insert(0, tmp);
            }
            num /= 1000;
            thindex++;
        }
        
        return sb.length() == 0 ? "Zero" : sb.toString().trim();
     }
     
     public String helper(int num, String[] tens, String[] lessthan20) {
         if(num == 0) {
             return "";
         }
         else if(num < 20) {
             return lessthan20[num] + " ";
         }
         else if(num < 100){
             return tens[num / 10] + " " + helper(num % 10, tens, lessthan20);
         }
         else {
             return lessthan20[num / 100] + " Hundred " + helper(num % 100, tens, lessthan20);
         }
     }
}