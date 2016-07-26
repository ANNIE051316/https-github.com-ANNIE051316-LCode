public class LRUCache {
    class DNode {
        int key; 
        int value;
        DNode prev, next;
        DNode(int key, int value) {
            this.key = key; 
            this.value = value;
        } 
    }
    
    int capacity;
    DNode head, tail;
    Map<Integer, DNode> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
    }
    
    public int get(int key) {
        DNode curnode = map.get(key);
        if(DNode == null) {
            return -1;
        }
        remove(curnode);
        addToHead(curnode);
        return curnode.value();
    }
    
    public void set(int key, int value) {
        DNode curnode = map.get(key);
        if(curnode == null) {
            if(capacity == map.size()) {
                map.remove(tail.key);
                remove(tail);
            }
            DNode tmp = new DNode(key, value);
            map.put(key, tmp);
            addToHead(tmp);
        }
        else {
            remove(curnode);
            curnode.value = value;
            addToHead(curnode);
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
    
    public void addToHead(DNode node) {
        node.next = head;
        if(head != null) {
            head.prev = node;
        }
        node.prev = null;
        head = node;
        
        if(tail == null) {
            tail = head;
        }
    }
    
}