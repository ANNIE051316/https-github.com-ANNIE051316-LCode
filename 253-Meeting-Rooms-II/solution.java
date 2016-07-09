/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            
            public int compare(Interval i1, Interval i2) {
                if(i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                return i1.end - i2.end;
            }
        });
        
        
       PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(11, new Comparator<Interval>() {
           @Override
           public int compare(Interval i1, Interval i2) {
               return i1.end - i2.end;
           }
       });
       int max = 0;
       for(Interval interval : intervals) {
           while(!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
               minHeap.poll();
           }
           
           minHeap.offer(interval);
           max = Math.max(max, minHeap.size());
       }
       return max;
       
    }
}