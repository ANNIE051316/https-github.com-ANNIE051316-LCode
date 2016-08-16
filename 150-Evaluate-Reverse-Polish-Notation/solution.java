public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer>  stack = new Stack();
        
        for(int i  = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                if(stack.size() < 2) {
                    return 0;
                }
                int oper2 = stack.pop();
                int oper1 = stack.pop();
                switch(tokens[i]) {
                    case "+":
                        stack.push(oper1 + oper2);
                        break;
                    case "-":
                        stack.push(oper1 - oper2);
                        break;
                    case "*":
                        stack.push(oper1 * oper2);
                        break;
                    case "/":
                        if(oper2 == 0) {
                            return Integer.MAX_VALUE;
                        }
                        stack.push(oper1 / oper2);
                        break;
                    default:
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return stack.size() == 1 ? stack.pop() : 0;
    }
}