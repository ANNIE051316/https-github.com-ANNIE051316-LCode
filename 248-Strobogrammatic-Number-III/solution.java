public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        char[][] pairs = {{'0','0'}, {'1','1'}, {'8','8'}, {'6','9'}, {'9', '6'}};
        int[] counts = new int[1];
        
        int l1 = low.length();
        int l2 = high.length();
        for(int i = l1; i <= l2; i++) {
            dfs(counts, pairs, low, high, new char[i], 0, i - 1);
        }
        return counts[0];
        
    }
    
    public void dfs(int[] counts, char[][] pairs, String low, String high, char[] path, int left, int right) {
        if(left > right) {
            String tmp = String.valueOf(path);
            if(path.length == low.length() && low.compareTo(tmp) > 0 || path.length == high.length() && high.compareTo(tmp) < 0) {
                return;
            }
            counts[0]++;
            return;
        }
        
        for(char[] pair : pairs) {
             if(left == 0 && pair[0] == '0' && path.length != 1 || left == right && pair[0] != pair[1]) {
                continue;
            }
            path[left] = pair[0];
            path[right] = pair[1];
            dfs(counts, pairs, low, high, path, left + 1, right - 1);
        }
    }
}