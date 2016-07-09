public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        helper(new char[n], 0, n / 2, res);
        return res;
    }
    
    public void helper(char[] word, int start, int end, List<String> res) {
        if(word.length % 2 == 0 && start >= end || word.length % 2 == 1 && start > end) {
            res.add(String.valueOf(word));
            return;
        }
        int left = start, right = word.length - 1 - left;
        word[left] = '1';
        word[right] = '1';
        helper(word, start + 1, end, res);
        word[left] = '8';
        word[right] = '8';
        helper(word, start + 1, end, res);
        if(left != 0 || word.length == 1) {
            word[left] = '0';
            word[right] = '0';
            helper(word, start + 1, end, res);
        }
        if(left != right) {
            word[left] = '6';
            word[right] = '9';
            helper(word, start + 1, end, res);
            word[left] = '9';
            word[right] = '6';
            helper(word, start + 1, end, res);
        }
    }
}