public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int res = words.length;
        for(int i = 0; i < words.length; i++) {
            if(word1.equals(words[i])) {
                if(word1.equals(word2) && index1 > index2) {
                    index2 = i;
                }
                else {
                    index1 = i;
                }
            }
            else if(word2.equals(words[i])) {
                index2 = i;
            }
            
            if(index1 >= 0 && index2 >= 0) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        
        return res;
    }
}