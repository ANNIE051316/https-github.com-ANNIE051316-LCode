public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        partitionhelper(s, 0, s.length() - 1, new ArrayList<String>(), res);
        return res;
    }
    
    public void partitionhelper(String s, int start, int end, List<String> path, List<List<String>> res) {
        
        if(start >= s.length()) {
            res.add(new ArrayList<String>(path));
            return;
        }
        
        for(int i = start; i <= end; i++) {
            String sub = s.substring(start, i + 1);
            if(isValid(sub)) {
                path.add(sub);
                partitionhelper(s, i + 1, end, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public boolean isValid(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            } 
            left++;
            right--;
        }
        return true;
    }
}