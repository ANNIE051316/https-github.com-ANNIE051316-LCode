public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList();
        helper(num, 0, 0, 0, target, new StringBuilder(), res);
        return res;
    }
    
    public void helper(String s, int start, int cursum, int prev, int target, StringBuilder path, List<String> res) {
        if(start == s.length()) {
            if(cursum == target) {
                res.add(path.toString());
            }
            return;
        }
        int len = path.length();
        for(int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if(sub.startsWith("0") && sub.length() > 1) {
                break;
            }
            int tmp = Integer.parseInt(sub);
            if(path.length() != 0) {
                path.append("+" + sub);
                helper(s, i, cursum + tmp, tmp, target, path, res);
                path.delete(len, path.length());
                path.append("-" + sub);
                helper(s, i, cursum - tmp, -tmp, target, path, res);
                path.delete(len, path.length());
                path.append("*" + sub);
                helper(s, i, cursum - prev + prev * tmp, prev * tmp, target, path, res);
                path.delete(len, path.length());
            }
            else {
                path.append(sub);
                helper(s, i, cursum + tmp, tmp, target, path, res);
                path.delete(len, path.length());
            }
        }
    }
}