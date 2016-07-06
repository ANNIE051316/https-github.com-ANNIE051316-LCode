public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x < y) {
            return canMeasureWater(y, x, z);
        }
        int gcd = gcd(x, y);
        if(gcd == 0) {
            return z== 0;
        }
        
        return z % gcd == 0 && (x + y) >= z;
    }
    
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}