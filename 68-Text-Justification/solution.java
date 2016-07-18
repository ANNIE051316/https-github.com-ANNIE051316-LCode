public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int start = 0;
        int len = 0;
        for(int i = 0; i < words.length; i++) {
            int l = words[i].length();
        
            if(len + l + i - start > maxWidth) {
                int spaces = maxWidth - len;
                StringBuilder sb = new StringBuilder();
                sb.append(words[start]);
                if(i == start + 1) {
                    for(int k = 0; k < spaces; k++) {
                        sb.append(' ');
                    }
                    start = i;
                    len = l;
                    res.add(sb.toString());
                }
                else {
                    int even = spaces / (i - 1 - start);
                    int extra  = spaces % (i - 1 - start);
                    while(start < i - 1) {
                        for(int k = 0; k < even; k++) {
                            sb.append(' ');
                        }
                        if(extra > 0) {
                            sb.append(' ');
                            extra--;
                        }
                        
                        sb.append(words[++start]);
                    }
                    len = l;
                    start = i;
                    res.add(sb.toString());
                }
            }
            else {
                len += l;
            }
            
            if(i == words.length - 1) {
                StringBuilder sb = new StringBuilder();
                int spaces = maxWidth - len;
                sb.append(words[start]);
                if(start == i) {
                    for(int k = 0; k < spaces; k++) {
                        sb.append(" ");
                    }
                }
                else {
                    int extra = spaces - (i - start);
                    while(start < i) {
                        sb.append(' ');
                        sb.append(words[++start]);
                    }
                    
                    for(int k = 0; k < extra; k++) {
                        sb.append(' ');
                    }
                }
                
                res.add(sb.toString());
                
            }
        }
        
        return res;
    }
}