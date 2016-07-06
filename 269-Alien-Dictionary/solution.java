public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }
        Set<Character>[] count = new HashSet[26];
        int charcount = 0;
        char[] chars = words[0].toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(count[chars[i] - 'a'] == null) {
                count[chars[i] - 'a'] = new HashSet<Character>();
                charcount++;
            }
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            char[] next = words[i + 1].toCharArray();
            int minLen = Math.min(chars.length, next.length);
            int j = 0;
            while(j < minLen) {
                if(chars[j] != next[j]) {
                    if(count[next[j] - 'a'] == null) {
                        count[next[j] - 'a'] = new HashSet<Character>();
                        charcount++;
                    }
                    count[next[j] - 'a'].add(chars[j]);
                    break;
                }
                j++;
            }
            
            while(j < next.length) {
                if(count[next[j] - 'a'] == null) {
                    count[next[j] - 'a'] = new HashSet<Character>();
                    charcount++;
                }
                j++;
            }
            chars = next;
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < 26; i++) {
            if(count[i] != null && count[i].size() == 0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            char c = (char)(cur + 'a');
            sb.append(c);
            charcount--;
            for(int i = 0; i < 26; i++) {
                if(count[i] != null && count[i].contains(c)) {
                    count[i].remove(c);
                    if(count[i].size() == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        
        return charcount == 0 ? sb.toString() : "";
        
        
    }
}