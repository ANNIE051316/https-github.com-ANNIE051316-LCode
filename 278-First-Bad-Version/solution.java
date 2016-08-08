/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n < 1) {
            throw new IllegalArgumentException("");
        }
        
        int left = 1, right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            boolean isbad = isBadVersion(mid);
            if(isbad) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}