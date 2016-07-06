public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 0) {
            return false;
        }
        for(int i = num / 2 + 1; i >= 1; i--) {
            if(num % i == 0 && num / i == i) {
                return true;
            }
        }
        
        return false;
    }
}