public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) {
            return true;
        }
        
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        Set<String> set = new HashSet<String>();
        for(int[] point : points) {
            minx = Math.min(minx, point[0]);
            maxx = Math.max(maxx, point[0]);
            String str = point[0] + "a" + point[1];
            set.add(str);
        }
        
        int target = minx + maxx;
        
        for(int[] point : points) {
           // int reflect = target - point[0];
            String str = (target - point[0]) +"a" + point[1];
            if(!set.contains(str)) {
                return false;
            }
        }
        
        return true;
    }
}