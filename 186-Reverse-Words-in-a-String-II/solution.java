public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) {
            return;
        }
        
        int left = 0, right = s.length - 1;
        reverse(s, left, right);
        
        left = 0; 
        while(left < s.length) {
            right = left;
            while(right < s.length && s[right] != ' ') {
                right++;
            }
            reverse(s, left, right - 1);
            left = right;
        }
        
    }
    
    public void reverse(char[] s, int left, int right) {
         while(left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }
    public void swap(char[] s, int left, int right) {
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
    }
}