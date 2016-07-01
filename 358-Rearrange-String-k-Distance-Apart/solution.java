import javafx.util.Pair;
public class Solution {
    public String rearrangeString(String str, int k) {
        if(str == null || str.length() == 0) {
            return "";
        }
        
        int len = str.length();
        int[] count = new int[26];
        int[] lastIndex = new int[26];
        boolean[] added = new boolean[26];
        for(int i = 0; i < len; i++) {
            char c = str.charAt(i);
            count[c - 'a']++;
        }
        
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<Pair<Character, Integer>>(11, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2){
                return (int)p2.getValue() - (int)p1.getValue();
            } 
            });
            
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                Pair<Character, Integer> tmp = new Pair<Character, Integer>((char)(i + 'a'), count[i]);
                pq.offer(tmp);
                added[i] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < len && !pq.isEmpty()) {
            Pair cur = pq.poll();
            char c = (char)cur.getKey();
            added[c - 'a'] = false;
            sb.append(c);
            lastIndex[c - 'a'] = index + 1;
            count[c - 'a']--;
            index++;
            for(int i = 0; i < 26; i++) {
                if(count[i] != 0 && !added[i] && (lastIndex[i] == 0 || index - lastIndex[i] >= k - 1)) {
                    pq.offer(new Pair((char)(i + 'a'), count[i]));
                    added[i] = true;
                }
            }
        }
        
        
        return sb.length() != len ? "" : sb.toString();
    }
}