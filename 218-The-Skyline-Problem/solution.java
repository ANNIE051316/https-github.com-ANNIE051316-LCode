public class Solution {
    class Point{
        int index;
        int height;
        boolean isstart;
        public Point(int index, int height, boolean isstart) {
            this.index = index;
            this.height = height;
            this.isstart = isstart;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        
        List<Point> points = new ArrayList();
        for(int[] building : buildings) {
            points.add(new Point(building[0], building[2], true));
            points.add(new Point(building[1], building[2], false));
        }
        
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.index != p2.index) {
                    return p1.index - p2.index;
                }
                else if(p1.isstart && p2.isstart) {
                    return p2.height - p1.height;
                }
                else if(!p1.isstart && !p1.isstart) {
                    return p1.height - p2.height;
                }
                else {
                    return p1.isstart ? -1 : 1; 
                }
            }
        });
        PriorityQueue<Integer> height = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        height.offer(0);
        for(Point point : points) {
            if(point.isstart) {
                if(point.height > height.peek()) {
                    res.add(new int[]{point.index, point.height});
                }
                height.offer(point.height);
            }
            else {
                height.remove(point.height);
                if(point.height > height.peek()) {
                    res.add(new int[]{point.index, height.peek()});
                }
            }
        }
        
        return res;
    }
}