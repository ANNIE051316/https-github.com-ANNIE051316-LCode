public class MovingAverage {
    Queue<Integer> queue;
    int windowsize;
    int curSum = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        this.windowsize = size;
    }
    
    public double next(int val) {
        if(queue.size() == this.windowsize) {
            curSum -= queue.poll();
        }
        
        queue.offer(val);
        curSum += val;
        return (double)curSum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */