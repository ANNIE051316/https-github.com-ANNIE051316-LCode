public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) {
            return true;
        }
        
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap();
        for(int[] point : points) {
            minx = Math.min(minx, point[0]);
            maxx = Math.max(maxx, point[0]);
            if(!map.containsKey(point[1])) {
                map.put(point[1], new HashSet<Integer>());
            }
            
            if(!map.get(point[1]).contains(point[0])) {
                map.get(point[1]).add(point[0]);
            }
        }
        
        double candidate = minx +  (maxx - minx) / 2;
        
        int target = minx + maxx;
        
        for(Set<Integer> set : map.values()) {
            Iterator<Integer> iter = set.iterator();
            while(iter.hasNext()) {
                    int cur = iter.next();
                    int reflect = target - cur;
                    if(!set.contains(reflect)) {
                        return false;
                    }
            }
        }
        
        return true;
    }
}