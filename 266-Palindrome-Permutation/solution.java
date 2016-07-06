public class Solution {
    public boolean canPermutePalindrome(String s) {
        int len = s.length();
        int odd = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        for(int i : map.values()) {
            if(i % 2 == 1) {
                odd++;
            }
        }
        
        return odd < 2;
    }
}