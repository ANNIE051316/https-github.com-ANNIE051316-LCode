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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList();
        boolean added = false;
        for(Interval interval : intervals) {
            if(added || interval.end < newInterval.start) {
                res.add(interval);
            }
            else {
                if(newInterval.end < interval.start) {
                    added = true;
                    res.add(newInterval);
                    res.add(interval);
                }
                else {
                    newInterval.start = Math.min(newInterval.start, interval.start);
                    newInterval.end = Math.max(newInterval.end, interval.end);
                }
            }
        }
        
        if(!added) {
            res.add(newInterval);
        }
        return res;
    }
}