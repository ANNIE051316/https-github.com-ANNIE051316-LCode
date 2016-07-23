public class Solution {
    public boolean isUgly(int num) {
        
        while(num != 1) {
            int backup = num;
            if(num % 2 == 0) {
                num /= 2;
            }
            if(num % 3 == 0) {
                num /= 3;
            }
            if(num % 5 == 0) {
                num /= 5;
            }
            if(num == backup) {
                break;
            }
        }
        
        return num == 1;
    }
}