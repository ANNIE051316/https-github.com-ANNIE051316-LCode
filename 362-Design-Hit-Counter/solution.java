public class HitCounter {
    int[] count;
    int[] times;

    /** Initialize your data structure here. */
    public HitCounter() {
        count = new int[300];
        times = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = (timestamp - 1) % 300;
        if(times[index] == timestamp) {
            count[index]++;
        }
        else {
            times[index] = timestamp;
            count[index] = 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for(int i = 0; i < 300; i++) {
            if(timestamp - times[i] < 300) {
                res += count[i];
            }
        }
        return res;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */