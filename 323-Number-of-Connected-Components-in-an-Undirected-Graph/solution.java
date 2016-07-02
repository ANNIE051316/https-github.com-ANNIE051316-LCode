public class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for(int[] edge : edges) {
            if(adj[edge[0]] == null) {
                adj[edge[0]] = new ArrayList<Integer>();
            }
            
            if(adj[edge[1]] == null) {
                adj[edge[1]] = new ArrayList<Integer>();
            }
            
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, visited, adj);
            }
        }
        
        return count;
    }
    
    public void dfs(int index, boolean[] visited, Set<Integer>[] adj) {
        visited[index] = true;
        if(adj[index] == null) {
            return;
        }
        for(Integer i : adj[index]) {
            if(!visited[i]) {
                dfs(i, visited, adj);
            }
        }
    
    }
}