public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            throw new IllegalArgumentException("");
        }
        
        if(beginWord.equals(endWord)) {
            return 2;
        }
        int count = 1;
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for(int i = 0; i < sz; i++) {
                String s = queue.poll();
                char[] cs = s.toCharArray();
                for(int j = 0; j < cs.length; j++) {
                    char backup = cs[j];
                    for(char tmp = 'a'; tmp < 'z'; tmp += 1) {
                        if(tmp != backup) {
                            cs[j] = tmp;
                            String curstring = String.valueOf(cs);
                            if(curstring.equals(endWord)) {
                                return count + 1;
                            }
                            if(wordList.contains(curstring) && !visited.contains(curstring)) {
                                queue.offer(curstring);
                                visited.add(curstring);
                            }
                        }
                    }
                    cs[j] = backup;
                }
            }
            count++;
        }
        
        return 0;
    }
}