public class Solution {
    public int nthUglyNumber(int n) {
        if(n < 1) {
            return Integer.MIN_VALUE;
        }
        
        int[] uglynums = new int[n];
        
        uglynums[0] = 1;
        int index = 1;
        int i2 = 0;
        int i3 = 0; 
        int i5 = 0;
        while(index < n) {
            int tmp2 = uglynums[i2] * 2;
            int tmp3 = uglynums[i3] * 3;
            int tmp5 = uglynums[i5] * 5;
            int min = Math.min(tmp2, Math.min(tmp3, tmp5));
            uglynums[index++] = min;
            if(min == tmp2) {
                i2++;
            }
            if(min == tmp3) {
                i3++;
            }
            if(min == tmp5) {
                i5++;
            }
        }
        
        return uglynums[n - 1];
    }
}