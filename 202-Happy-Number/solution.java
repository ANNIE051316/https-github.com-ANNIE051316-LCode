public class Solution {
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        while(n != 1) {
            if(set.contains(n)) {
                return false;
            }
            set.add(n);
            int tmp = 0; 
            while(n != 0) {
                int mod = n % 10;
                tmp += mod * mod;
                n = n / 10;
            }
            n = tmp;
        }
        
        return true;
    }
}