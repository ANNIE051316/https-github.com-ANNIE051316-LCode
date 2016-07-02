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
            if(!find(id, edge[0], edge[1])) { 
                unite(id, sz, edge[0], edge[1]);
                count--;
            }
        }
        
        return count;
    }
    
    public boolean find(int[] id, int p, int q) {
        return root(id, p) == root(id, q);
    }
    
    private int root(int[] id, int i) {
        while(id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    public void unite(int[] id, int[] sz, int p, int q) {
        int i = root(id, p);
        int j = root(id, q);
        
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        
    }
}