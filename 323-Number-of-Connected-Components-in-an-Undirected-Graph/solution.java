public class Solution {
    
    public int countComponents(int n, int[][] edges) {
        if(n <= 0) {
            return 0;
        }
        
        int[] id = new int[n];
        int[] sz = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        int count = n;
        for(int[] edge : edges) {
            int i = root(id, edge[0]);
            int j = root(id, edge[1]);
            if(i != j) {
                if(sz[i] < sz[j]) {
                    id[i] = j;
                    sz[j] += sz[i];
                }
                else {
                    id[j] = i;
                    sz[i] += sz[j];
                }
                count--;
            }
        }
        
        return count;
    }
    
    
    private int root(int[] id, int i) {
        while(id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
  
}