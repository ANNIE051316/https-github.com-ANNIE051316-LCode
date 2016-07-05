public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) {
            return 0;
        }
        int p1 = k;
        if(n == 1) {
            return p1;
        }
        int p2 = k * k;
        if(n == 2) {
            return p2;
        }
        int p3 = p2 * k - k;
        
        for(int i = 4; i <= n; i++) {
            int tmp = p3 * k - p1 * (k - 1);
            p1 = p2;
            p2 = p3;
            p3 = tmp;
        }
        
        return p3;
        
    }
}