public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) {
            return 0;
        }
        int[] elements = new int[words.length];
        
        for(int i = 0; i < words.length; i++) {
            int tmp = 0;
            for(int j = 0; j < words[i].length(); j++) {
                tmp |= (1 << (words[i].charAt(j) - 'a'));
            }
            elements[i] = tmp;
        }
        
        int res = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if((elements[i] & elements[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        
        return res;
    }
}