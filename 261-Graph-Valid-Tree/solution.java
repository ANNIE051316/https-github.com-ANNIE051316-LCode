public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges == null || edges.length == 0 || edges[0].length == 0) {
            return n <= 1;
        }
        Set<Integer>[] adj = new Set[n];
        
        for(int i = 0; i < edges.length; i++) {
            if(adj[edges[i][0]] == null) {
                adj[edges[i][0]] = new HashSet<Integer>();
            }    
            if(adj[edges[i][1]] == null) {
                adj[edges[i][1]] = new HashSet<Integer>();
            }    
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        visited[0] = true;
        //visited[0] = true;
        while(!queue.isEmpty()) {
            int i = queue.poll();
            if(adj[i] == null) {
                continue;
            }
            Iterator it = adj[i].iterator();
            while(it.hasNext()) {
                int num = (Integer)it.next();
                if(!visited[num]) {
                    queue.offer(num);
                    visited[num] = true;
                    adj[num].remove(i);
                }
                else {
                    return false;
                }
                it.remove();
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
        
    }
}