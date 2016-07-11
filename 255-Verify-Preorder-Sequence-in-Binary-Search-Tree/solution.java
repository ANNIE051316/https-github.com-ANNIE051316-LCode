public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return valid(preorder, 0, preorder.length - 1, Long.MIN_VALUE, Long.MAX_VALUE);       
    }
    
    public boolean valid(int[] preorder, int start, int end, long min, long max) {
        if(start > end) {
            return true;
        }
        
        if(preorder[start] <= min || preorder[start] >= max) {
            return false;
        }
        int index = -1;
        for(int i = start; i < end; i++) {
            if(preorder[i + 1] > preorder[start]) {
                index = i;
                break;
            }
        }
        
        return valid(preorder, start + 1, index, min, preorder[start]) && valid(preorder, Math.max(index + 1, start + 1), end, preorder[start], max); 
    }
}