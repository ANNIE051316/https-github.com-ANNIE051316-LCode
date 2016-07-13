public class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int xor = a ^ b;
            int and = a & b;
            a = xor | (and << 1);
            b = xor & (and << 1);
        }
        
        return a;
    }
}