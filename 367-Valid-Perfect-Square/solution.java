public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 0) {
            return false;
        }
        
        int left = 1, right = num;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long tmp = mid * mid;
            if(tmp == num) {
                return true;
            }
            else if(tmp > num){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}