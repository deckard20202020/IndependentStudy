package Stack;

import java.util.Stack;

public class Stack_Medium_150_EvaluateReversePolishNotation {
    public static void main(String[] args) {
//        String[] tokens = {"2","1","+","3","*"};
        String[] tokens = {"4","13","5","/","+"};
        int answer = evalRPN(tokens);
        System.out.println(answer);
    }

    private static int evalRPN(String[] tokens) {

        //base case
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }

        //idea
        //if it's a number, put it in a stack
        //if it's an operator, pop two numbers and operate on them



        Stack<Integer> stack = new Stack<>();

        int answer = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int first = stack.pop();
                int second = stack.pop();
                if (tokens[i].equals("+")) {
                    answer = second + first;
                    stack.push(answer);
                }
                if (tokens[i].equals("-")) {
                    answer = second - first;
                    stack.push(answer);
                }
                if (tokens[i].equals("*")) {
                    answer = second * first;
                    stack.push(answer);
                }
                if (tokens[i].equals("/")) {
                    answer = second / first;
                    stack.push(answer);
                }
            }
        }

        return answer;
    }

}
