public class Solution {
    public int wiggleMaxLength(int[] nums) {
        Stack<Integer> stack = new Stack();
        int i = 0;
        for(int num : nums) {
            if((i & 1) == 0) { // small
                if(stack.isEmpty() || stack.peek() > num) {
                    i++;
                }
                else {
                    stack.pop();
                }
            }
            else {
                if(stack.peek() < num) {
                    i++;
                }
                else {
                    stack.pop();
                }
            }
            stack.push(num);
        }
        
        
        Stack<Integer> stack2 = new Stack<Integer>();
        i = 0;
        for(int num : nums) {
            if((i & 1) == 0) { // big
                if(stack2.isEmpty() || stack2.peek() < num) {
                    i++;
                }
                else {
                    stack2.pop();
                }
            }
            else {
                if(stack2.isEmpty() || stack2.peek() > num) { // small
                    i++;
                }
                else {
                    stack2.pop();
                }
            }
            
            stack2.push(num);
        }
        return Math.max(stack.size(), stack2.size());
    }
}