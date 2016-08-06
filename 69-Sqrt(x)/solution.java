public class Solution {
    public int mySqrt(int x) {
        if(x < 0) {
            throw new IllegalArgumentException("input x is smaller than 0");
        }
        
        int left = 0, right = x / 2 + 1;
        while(left <= right) {
            int mid = left  + (right - left) / 2;
            long cur = (long)mid * (long)mid;
            if(cur == x) {
                return mid;
            }
            else if(cur > x) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return right;
    }
}