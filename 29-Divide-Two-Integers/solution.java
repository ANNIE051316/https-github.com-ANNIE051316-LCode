public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return dividend == 0 ? 0 : Integer.MAX_VALUE;
        }
        
        int flag = 1;
        long divid = (long)dividend;
        if(divid < 0) {
            divid = -divid;
            flag = -flag;
        }
        long divis = (long)divisor;
        if(divis < 0) {
            divis = -divis;
            flag = -flag;
        }
        long res = 0;
        while(divid >= divis) {
            long count = 1;
            long tmp = divis;
            while(tmp <= divid) {
                tmp <<= 1;
                count <<= 1;
            }
            res += (count >> 1);
            divid -= (tmp >> 1);
            
        }
       
       if(flag == 1) {
           res = Math.min(Integer.MAX_VALUE, res);
       }
       else {
           res = Math.max(Integer.MIN_VALUE, -res);
       }
       return (int)res;
       
    }
}