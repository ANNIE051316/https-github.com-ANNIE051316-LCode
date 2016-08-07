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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList();
        if(intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                return i1.end - i2.end;
            }
        });
        
        Interval tmpinterval = intervals.get(0);
        for(Interval interval : intervals) {
            if(tmpinterval.end < interval.start) {
                res.add(tmpinterval);
                tmpinterval = interval;
            }
            else {
                tmpinterval.start = Math.min(tmpinterval.start, interval.start);
                tmpinterval.end = Math.max(tmpinterval.end, interval.end);
            }
        }
        
        res.add(tmpinterval);
        return res;
    }
}