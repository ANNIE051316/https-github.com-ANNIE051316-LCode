public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int total = m * n;
        int[] id = new int[total];
        int[] sz = new int[total];
        boolean[] land = new boolean[total];
        for(int i = 0; i < total; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        int islands = 0;
        List<Integer> res = new ArrayList<Integer>();
        for(int[] position : positions) {
            
            if(land[position[0] * m + position[1]]) {
                res.add(islands);
                continue;
            }
            
            islands = helper(m, n, id, land, sz, position, islands);
            res.add(islands);
        }
        
        return res;
    }
    
    public int helper(int m, int n, int[] id, boolean[] land, int[] sz, int[] position, int islands) {
        int x = position[0];
        int y = position[1];
        land[x * m + y] = true;
        islands++;
        // up
        if(x > 0 && land[(x -1) * m + y]) {
           if(unite(x * m + y, (x - 1) * m + y, id, sz)) {
               islands--;
           }
        }
        
        // left
        if(y > 0 && land[x * m + y - 1]) {
           if(unite(x * m + y, x * m + y - 1, id, sz)) {
               islands--;
           }
        }
        //down 
        if(x < m - 1 && land[(x + 1) * m + y]) {
           if(unite(x * m + y, (x + 1) * m + y, id, sz)) {
               islands--;
           }
        }
        
        // right
        if(y < n - 1 && land[x * m + y + 1]) {
           if(unite(x * m + y, x * m + y + 1, id, sz)) {
               islands--;
           }
        }
        return islands;
    }
    
    private boolean unite(int i, int j, int[] id, int[] sz) {
        int ri = root(i, id);
        int rj = root(j, id);
        if(ri == rj) {
            return false;
        }
        
        if(sz[i] >= sz[j]) {
            id[rj] = ri;
            sz[ri] += sz[rj];
        }
        else {
            id[ri] = rj;
            sz[rj] += sz[ri];
        }
        return true;
    }
    
    
    private int root(int i, int[] id) {
        while(id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}