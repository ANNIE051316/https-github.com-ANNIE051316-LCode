public class MovingAverage {
    private int[] window;
    private int n, insert;
    private long sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
    }
    
    public double next(int val) {
        if(n < window.length) {
            n++;
        }
        sum -= window[insert];
        window[insert] = val;
        sum += val;
        insert = (insert + 1) % window.length;
        
        return (double)sum / n;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */