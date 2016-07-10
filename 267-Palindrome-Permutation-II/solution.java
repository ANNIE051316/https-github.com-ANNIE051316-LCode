public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = s.length();
        int oddcount = 0;
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }
        String mid = "";
        List<Character> charlist = new ArrayList<Character>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(value % 2 == 1) {
                oddcount += 1;
                mid = mid + key;
                
            }
           for(int i = value / 2; i > 0; i--) {
                charlist.add(key);
            }
        }
        
        
        if(oddcount > 1) {
            return res;
        }
        
        boolean[] used = new boolean[charlist.size()];
        List<StringBuilder> halflist = new ArrayList<StringBuilder>();
        backtracking(charlist, 0, used, new StringBuilder(), halflist);
        
        for(StringBuilder sb : halflist) {
            StringBuilder reverse = (new StringBuilder(sb)).reverse();
            sb.append(mid);
            sb.append(reverse);
            res.add(sb.toString());
        }
       
        return res;
    }
    
    public void backtracking(List<Character> charlist, int count, boolean[] used, StringBuilder sb, List<StringBuilder> res) {
        if(count == used.length) {
            res.add(new StringBuilder(sb));
            return;
        }
        
        for(int i = 0; i < used.length; i++) {
            if(used[i] || (i > 0 && charlist.get(i) == charlist.get(i - 1) && !used[i - 1])) {
                continue;
            }
            
            sb.append(charlist.get(i));
            used[i] = true;
            backtracking(charlist, count + 1, used, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}