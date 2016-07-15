public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x < y) {
            return canMeasureWater(y, x, z);
        }
        
        int gcd = getgcd(x, y);
        if(gcd == 0) {
            return z == 0;
        }
        return z % gcd == 0 && x + y >= z;
        
    }
    
    public int getgcd(int x, int y) {
        return (y == 0 ? x : getgcd(y, x % y));
    }
}