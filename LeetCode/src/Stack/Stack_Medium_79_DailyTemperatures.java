package Stack;

import java.util.Stack;

public class Stack_Medium_79_DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] answers = dailyTemperatures(temperatures);
        System.out.println(temperatures);
    }

    private static int[] dailyTemperatures(int[] temperatures) {

        //we only iterate through the array once and
        //no values will be put into stack more than once
        //So we have O(n) time.
        //We use the stack to store n numbers
        //So O(n) space

        //this is our return value
        int[] answers = new int[temperatures.length];

        //the stack will store the index of the currDay
        Stack<Integer> stack = new Stack<>();

        //scroll through the tempuratures
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            int currTemp = temperatures[currDay];

            //update answers
            //remember stack is not storing temps.  it is storing day indexes
            while (!stack.isEmpty() && temperatures[stack.peek()] < currTemp) {
                int prevDay = stack.pop();
                answers[prevDay] = currDay - prevDay;
            }

            stack.push(currDay);

        }

        return answers;
    }
}
