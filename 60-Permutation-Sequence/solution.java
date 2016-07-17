public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int factor = 1;
        for(int i = 2; i < n; i++) {
            factor *= i;
        }
        
        k = k - 1;
        
        boolean[] used = new boolean[n];
        for(int i = 1; i <= n; i++) {
            int index = k / factor;
            k %= factor;
            if(i != n ) {
                factor = factor / (n - i);
            }
            int count = -1;
            for(int j = 0; j < n; j++) {
                if(!used[j]) {
                    count++;
                }
                
                if(count == index) {
                    index = j;
                    break;
                }
            }
            
            sb.append(index + 1);
            used[index] = true;
        }
        
        return sb.toString();
        
    }
}