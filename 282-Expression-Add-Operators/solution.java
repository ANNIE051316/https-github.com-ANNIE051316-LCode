public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList();
        
        if(num == null || num.length() == 0) {
            return res;
        }
        
        for(int i = 1; i <= num.length(); i++) {
            String sub = num.substring(0, i);
            if(sub.length() > 1 && sub.charAt(0) == '0') {
                break;
            }
            helper(num, i, Long.parseLong(sub), Long.parseLong(sub), sub, target, res);
        }
        
        return res;
    }
    
    public void helper(String num, int index, long cursum, long prenum, String path, int target, List<String> res) {
        if(index == num.length()) {
            if(cursum == target) {
                res.add(path);
            }
            return;
        }
        
        for(int i = index + 1; i <= num.length(); i++) {
            String sub = num.substring(index, i);
            if(sub.length() > 1 && sub.charAt(0) == '0') {
                break;
            }
            long curnum = Long.parseLong(sub);
            helper(num, i, cursum + curnum, curnum, path +"+" + sub, target, res);
            helper(num, i, cursum - curnum, -curnum, path + '-' + sub, target, res);
            helper(num, i, cursum - prenum + prenum * curnum, prenum * curnum, path + "*" + sub, target, res);
        }
    }
}