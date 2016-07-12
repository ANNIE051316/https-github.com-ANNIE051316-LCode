public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int p : preorder) {
            if(p < low) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() < p) {
                low = stack.pop();
            }
            stack.push(p);
        }
        
        return true;
    }
}