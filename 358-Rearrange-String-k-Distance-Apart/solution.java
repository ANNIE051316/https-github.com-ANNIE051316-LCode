public class Solution {
    public String rearrangeString(String str, int k) {
        if(str == null || str.length() == 0) {
            return "";
        }
        
        int count[] = new int[26];
        int index[] = new int[26];
        
        int len = str.length();
        for(int i = 0; i < len; i++) {
            char c = str.charAt(i);
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        int curIndex = 0;
        while(curIndex < len) {
            int candidatePos = findMaxCandidate(count, index, curIndex, k);
            if(candidatePos == -1) {
                return "";
            } 
            
            sb.append((char)(candidatePos + 'a'));
            count[candidatePos]--;
            index[candidatePos] = curIndex + 1;
            curIndex++;
        }
        
        return sb.toString();
    }
    
    public int findMaxCandidate(int[] count, int[] index, int curIndex, int k) {
        int candidatePos = -1;
        int curMax = 0;
        for(int i = 0; i < 26; i++) {
            if(count[i] > 0 && (index[i] == 0 || curIndex - index[i] >= k - 1) && count[i] > curMax) {
                curMax = count[i];
                candidatePos = i;
            }
        }
        
        return candidatePos;
    }
}