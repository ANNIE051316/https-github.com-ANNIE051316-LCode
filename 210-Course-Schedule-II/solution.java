public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) {
            throw new IllegalArgumentException("");
        }   
        int[] res = new int[numCourses];
        int index = 0;
        Map<Integer, List<Integer>> map = new HashMap();
        int[] count = new int[numCourses];
        for(int[] prereq : prerequisites) {
            count[prereq[0]]++;
            if(!map.containsKey(prereq[1])) {
                map.put(prereq[1], new ArrayList());
            }
            map.get(prereq[1]).add(prereq[0]);
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(count[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            res[index++] = cur;
            if(map.containsKey(cur)) {
                for(int course : map.get(cur)) {
                    if(--count[course] == 0) {
                        queue.offer(course);
                    }
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
}