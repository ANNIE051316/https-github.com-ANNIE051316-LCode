public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] ids = new int[n];
        int[] sz = new int[n];
        for(int i = 0; i < n; i++) {
            ids[i] = i;
            sz[i] = 1;
        }
        
        for(int[] edge : edges) {
            int l = root(edge[0], ids);
            int r = root(edge[1], ids);
            if(l == r) {
                return false;
            }
            if(sz[l] >= sz[r]) {
                ids[r] = l;
                sz[l] += sz[r];
            }
            else {
                ids[l] = r;
                sz[r] += sz[l];
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(sz[i] == n) {
                return true;
            }
        }
        
        return false;
    }
    
    public int root(int i, int[] ids) {
        while(ids[i] != i) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        
        return i;
    }
}