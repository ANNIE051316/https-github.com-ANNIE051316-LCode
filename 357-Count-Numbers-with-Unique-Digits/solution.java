public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        
        int res = 10;
        int prev = 9;
        int numsavailable = 9;
        while(n > 1 & numsavailable > 0) {
            prev = prev * numsavailable;
            numsavailable--;
            res += prev;
            n--;
        }
        return res;
    }
}