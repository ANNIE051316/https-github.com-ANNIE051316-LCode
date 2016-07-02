public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        int start = 0;
        int len = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c) && map.size() >= k) {
                int removechar = i;
                char chartoremove = '#';
                Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
                while(iter.hasNext()) {
                    Map.Entry<Character, Integer> entry = iter.next();
                    if(entry.getValue() < removechar) {
                        removechar = entry.getValue();
                        chartoremove = entry.getKey();
                    }
                }
                
                map.remove(chartoremove);
                start = removechar + 1;
            }
            
            map.put(c, i);
            
            res = Math.max(res, i - start + 1);
        }
        
        return res;
    }
}