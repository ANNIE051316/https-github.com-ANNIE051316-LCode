public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int m = image.length; 
        int n = image[0].length;
        int left = searchcols(0, y, 0, m, true, image);
        int right = searchcols(y + 1, n - 1, 0, m, false, image);
        int top = searchrows(0, x, 0, n, image, true);
        int bottom = searchrows(x + 1, m - 1, 0, n, image, false);
        
        return (right - left) * (bottom - top);
    }
    
    public int searchcols(int i, int j, int top, int bottom, boolean opt, char[][] image) {
        while(i <= j) {
            int k = top; 
            int mid = i + (j - i) / 2;
            while(k < bottom && image[k][mid] == '0') {
                k++;
            }
            if(k < bottom == opt) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }
        
        return i;
    }
    
    
    public int searchrows(int i, int j, int left, int right, char[][] image, boolean opt) {
        while(i <= j) {
            int mid = i + (j - i) / 2;
            int k = left;
            while(k < right && image[mid][k] == '0') {
                k++;
            }
            if(k < right == opt) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }
        return i;
    
    }
}