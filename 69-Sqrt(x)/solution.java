public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        
        int left = 1, right = (x >> 1) + 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long mul = (long)mid * (long)mid;
            if(mul == x) {
                return mid;
            }
            else if(mul > x) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return right;
    }
}