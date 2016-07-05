public class ZigzagIterator {
    Queue<Iterator> iter;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter = new LinkedList<Iterator>();
        iter.offer(v1.iterator());
        iter.offer(v2.iterator());
    }

    public int next() {
        Iterator it = iter.poll();
        int tmp = (int)it.next();
        iter.offer(it);
        return tmp;
    }

    public boolean hasNext() {
        if(iter.isEmpty()) {
            return false;
        }
        while(!iter.isEmpty() && !iter.peek().hasNext()) {
            iter.poll();
        }
        
        return !iter.isEmpty();
        
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */