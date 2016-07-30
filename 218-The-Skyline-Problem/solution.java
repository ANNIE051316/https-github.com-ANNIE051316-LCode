class Edge{
    int x;
    int height;
    boolean isStart;
    Edge(int x, int height, boolean isStart) {
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }
}

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        
        List<Edge> edges = new ArrayList<Edge>();
        
        for(int[] building : buildings) {
            edges.add(new Edge(building[0], building[2], true));
            edges.add(new Edge(building[1], building[2], false));
        }
        
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                if(e1.x != e2.x) {
                    return e1.x - e2.x;
                }
                else if(e1.isStart && e2.isStart) {
                    return e2.height - e1.height;
                }
                else if(!e1.isStart && !e2.isStart) {
                    return e1.height - e2.height;
                }
                else {
                    return e1.isStart ? -1 : 1;
                }
            }
        });
        
        PriorityQueue<Integer> height = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        
        for(Edge edge : edges) {
            if(edge.isStart) {
                if(height.isEmpty() || height.peek() < edge.height) {
                    res.add(new int[]{edge.x, edge.height});
                }
                height.add(edge.height);
            }
            else {
                height.remove(edge.height);
                if(height.isEmpty()) {
                    res.add(new int[]{edge.x, 0});
                }
                else if(height.peek() < edge.height){
                    res.add(new int[]{edge.x, height.peek()});
                }
            }
        }
        
        return res;
        
        
    }
}