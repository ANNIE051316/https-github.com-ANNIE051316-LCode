public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 0) {
            return false;
        }
        int left = 1; int right = num / 2 + 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long tmp = (long)mid * (long)mid;
            if(tmp > num) {
                right = mid - 1;
            }
            else if(tmp < num) {
                left = mid + 1;
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}