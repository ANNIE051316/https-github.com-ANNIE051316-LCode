public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        
        int left = 0, right = citations.length;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(citations[mid] >= citations.length - mid && (mid == 0 || citations[mid - 1] <= citations.length - mid)) {
                return citations.length - mid;
            }
            else if(citations[mid] < citations.length - mid) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return citations.length - left;
    }
}