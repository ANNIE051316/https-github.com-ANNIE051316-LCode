public class Solution {
    public int getSum(int a, int b) {
        int xor = 0;
        int and = 0;
        do{
             xor = a ^ b;
             and = a & b;
            a = (and << 1) | xor;
            b = xor & (and << 1);
        }while(b != 0);
        
        return a;
    }
}