public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }   
        
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                    count++;
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        int resx = x.get(count / 2);
        int resy = y.get(count / 2);
        
        int res = 0;
        for(int i : x) {
            res += Math.abs(i - resx);
        }
        for(int i : y) {
            res += Math.abs(i - resy);
        }
        return res;
    }
}