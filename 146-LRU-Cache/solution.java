public class LRUCache {
    
    public class DNode{
        int key;
        int val;
        DNode prev, next;
        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Map<Integer, DNode> map;
    DNode head, tail;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        DNode cur = map.get(key);
        remove(cur);
        inserthead(cur);
        return cur.val;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            DNode cur = map.get(key);
            remove(cur);
            cur.val = value;
            inserthead(cur);
        }
        else {
            if(this.capacity == map.size()) {
                map.remove(tail.key);
                remove(tail);
            }
            DNode tmp = new DNode(key, value);
            map.put(key, tmp);
            inserthead(tmp);
        }
    }
    
    public void remove(DNode node) {
        if(node.next == null) {
            tail = node.prev;
        }
        else {
            node.next.prev = node.prev;
        }
        
        if(node.prev == null) {
            head = node.next;
        }
        else {
            node.prev.next = node.next;
        }
    }
    
    public void inserthead(DNode node) {
        node.next = head;
        node.prev = null;
        if(head != null) {
            head.prev = node;
        }
        head = node;
        if(tail == null) {
            tail = node;
        }
    }
}