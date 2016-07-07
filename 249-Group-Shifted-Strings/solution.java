public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strings) {
            StringBuilder sb = new StringBuilder();
            int len = s.length();
            int offset = s.charAt(0) - 'a';
            sb.append('a');
            for(int i = 1; i < len; i++) {
                sb.append((char)((s.charAt(i) + 26 - offset) % 26));
            }
            String key = sb.toString();
            if(!map.containsKey(key)) {
                map.put(key, new LinkedList<String>());
            }
            map.get(key).add(s);
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        for(List<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
}