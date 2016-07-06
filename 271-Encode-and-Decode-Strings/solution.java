public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length() + "/" + s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        int curlen = 0;
        int index = 0;
        while(index < len) {
            char c = s.charAt(index);
            if(c != '/') {
                curlen = curlen * 10 + c - '0';
                index++;
            }
            else {
                if(curlen)
                res.add(s.substring(index + 1, index + curlen + 1));
                index = index + curlen + 1;
                curlen = 0;
            }
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));