package Stack;

import java.util.Stack;

public class Stack_Easy_20_ValidParentheses {
    public static void main (String[] args) {
        String s = "()";
        boolean answer = isValid(s);
        System.out.println(answer);
    }

    private static boolean isValid(String s) {

            //we will always have a non empty string
            //string will only contain ()[]{}

            //idea
            //iterate through the string
            //if opening parenthesis put in a stack
            //if closing paranthesis
            //pop the stack and make sure it is the correct parenthesis
            //if not return false
            //when we are done check to make sure the stack is empty
            //if so return true
            //else return false

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    //check to see that the stack isn't empty
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char popped = stack.pop();
                    if (c == ')' && popped == '(') {
                        continue;
                    } else if (c == ']' && popped == '[') {
                        continue;
                    } else if (c == '}' && popped == '{') {
                        continue;
                    } else return false;
                }
            }

            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
    }
}
