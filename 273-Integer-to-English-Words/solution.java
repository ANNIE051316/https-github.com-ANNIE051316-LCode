public class Solution {
    public String numberToWords(int num) {
        String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
        String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ones = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        int i = 0; 
        StringBuilder sb = new StringBuilder();
        
        while(num != 0)  {
            if(num % 1000 != 0) {
                String tmpsb = helper(num % 1000, tens, ones);
                tmpsb = tmpsb + thousands[i] + " ";
                sb.insert(0, tmpsb);
            }
            
            num /= 1000;
            i++;
        }
        
        return sb.length() == 0 ? "Zero" : sb.toString().trim();
    }
    
    public String helper(int num, String[] tens, String[] ones) {
        if(num == 0) {
            return "";
        }
        else if(num < 20) {
            return ones[num] + " ";
        }
        else if(num < 100){
            return tens[num / 10] + " " + helper(num % 10, tens, ones);
        }
        else {
            return ones[num / 100] + " Hundred " + helper(num % 100, tens, ones);
        }
    } 
}