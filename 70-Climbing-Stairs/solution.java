public class Solution {
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        
        int prev1 = 1, prev2 = 2;
        for(int i = 3; i <= n; i++) {
            int tmp = prev1 + prev2;
            prev1 = prev2;
            prev2 = tmp;
        }
        return prev2;
    }
}