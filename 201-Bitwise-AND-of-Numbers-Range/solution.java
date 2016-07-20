public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while(m < n && n > 0) {
            n = n & (n - 1);
        }
        return n;
    }
}