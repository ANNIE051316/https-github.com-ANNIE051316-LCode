/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        if(points.length == 1) {
            return 1;
        }
        Arrays.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.x != p2.x) {
                    return p1.x - p2.x;
                }
                
                if(p1.y != p2.y) {
                    return p1.y - p2.y;
                }
                return 0;
            } 
        });
        
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            if(i != 0 && points[i].x == points[i - 1].x && points[i].y == points[i - 1].y) {
                continue;
            }
            Map<Double, Integer> map = new HashMap();
            int same = 1; 
            for(int j = i + 1; j < points.length; j++) {
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                    continue;
                }
                double slope = ((double)(points[i].y - points[j].y)) / (points[i].x - points[j].x);
                map.put(slope, map.get(slope) == null ? 1 : map.get(slope) + 1);
            }
            
            int tmpmax = 0;
            for(int value : map.values()) {
                tmpmax = Math.max(tmpmax, value);
            }
            tmpmax += same;
            res = Math.max(res, tmpmax);
        }
        
        return res;
    }
}