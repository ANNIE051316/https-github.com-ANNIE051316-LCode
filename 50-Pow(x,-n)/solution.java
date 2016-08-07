public class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            return 1 / (myPow(x, -(n + 1)) * x);
        }
        
        if(n == 0) {
            return 1;
        }
        
        double half = myPow(x, n / 2);
        if(n % 2 == 0) {
            return half * half;
        }
        else {
            return half * half * x;
        }
    }
}