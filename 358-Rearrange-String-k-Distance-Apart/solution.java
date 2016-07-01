import javafx.util.Pair;
public class Solution {
    public String rearrangeString(String str, int k) {
        if(str == null || str.length() == 0) {
            return "";
        }
        
        int len = str.length();
        int[] count = new int[26];
        for(int i = 0; i < len; i++) {
            char c = str.charAt(i);
            count[c - 'a']++;
        }
        
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<Pair<Character, Integer>>(11, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2){
                int v1 = (int)p1.getValue();
                int v2 = (int)p2.getValue();
                if(v1 == v2) {
                    return (char)p1.getKey() - (char)p2.getKey();
                } 
                return v2 - v1;
            } 
            });
            
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                Pair<Character, Integer> tmp = new Pair<Character, Integer>((char)(i + 'a'), count[i]);
                pq.offer(tmp);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Pair> queue = new LinkedList<Pair>();
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            char c = (char)cur.getKey();
            sb.append(c);
            queue.offer(new Pair(c, --count[c - 'a']));
            
            if(queue.size() < k) {
                continue;
            }
            Pair head = queue.poll();
            if((int)head.getValue() != 0) {
                pq.offer(head);
            }
        }
        
        return sb.length() != len ? "" : sb.toString();
    }
}