public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        String[] letter = new String[]{ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, 0, letter, new StringBuilder(), res);
        return res;
    }
    
    public void helper(String digits, int index, String[] letter, StringBuilder path, List<String> res) {
        if(index == digits.length() ) {
            if(path.length() != 0) {
                res.add(path.toString());
            }
            return;
        }
        
        char c = digits.charAt(index);
        if(letter[c - '0'].equals("")) {
            helper(digits, index + 1, letter, path, res);
        }
        else {
            for(int i = 0; i < letter[c - '0'].length(); i++) {
                char t = letter[c - '0'].charAt(i);
                path.append(t);
                helper(digits, index + 1, letter, path, res);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}