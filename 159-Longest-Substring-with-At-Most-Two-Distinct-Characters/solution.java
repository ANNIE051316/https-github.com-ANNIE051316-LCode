public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0;
        int len = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c) && map.size() == 2) {
                max = Math.max(max, i - start);
                int newstart = i;
                char chartoremove = '0';
                for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                    int value = entry.getValue();
                    if(value < newstart) {
                        newstart = value;
                        chartoremove = entry.getKey();
                    }
                }
                
                start = newstart + 1;
                map.remove(chartoremove);
            }
            map.put(c, i);
        }
        
        max = Math.max(max, len - start);
        return max;
    }
}