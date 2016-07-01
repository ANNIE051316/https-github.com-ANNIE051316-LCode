public class Solution {
    public String rearrangeString(String str, int k) {
        if(str == null || str.length() == 0) {
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = str.length();
        for(int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue(11, new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                int diff = e2.getValue() - e1.getValue();
                if(diff == 0) {
                    return e1.getKey() - e2.getKey();
                }
                
                return diff;
                
            }
        });
        
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        List<Map.Entry<Character, Integer>> tmpList = new ArrayList<Map.Entry<Character, Integer>>();
        
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> current = pq.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);
            tmpList.add(current);
            if(tmpList.size() < k) {
                continue;
            }
            Map.Entry<Character, Integer> front = tmpList.poll(0);
            if(front.getValue() != 0) {
                pq.offer(front);
            }
        }
        
        return sb.length() != len ? "" : sb.toString();
    }
}