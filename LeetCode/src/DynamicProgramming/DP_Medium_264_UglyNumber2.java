package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DP_Medium_264_UglyNumber2 {
    public static void main(String[] args) {
        int n = 11;
        int answer = nthUglyNumber(n);
        System.out.println(answer);
    }

    private static int nthUglyNumber(int n) {

        //each ugly number can be written as 2^i * 3^j  * 5^k
        //ex 1 = 2^0 * 3^0 * 5^0
        //we can keep track of these number in an array

        //base case
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;

        //keep track of exponents
        int numTwos = 0;
        int numThrees = 0;
        int numFives = 0;

        for (int i = 1; i < dp.length; i++) {

            //three new candidates
            //found by increasing one of the exponents
            int addTwo = dp[numTwos] * 2;
            int addThree = dp[numThrees] * 3;
            int addFive = dp[numFives] * 5;

            //find the minimum of the three candidates
            int min = Math.min(addTwo, Math.min(addThree, addFive));

            //place the new ugly number in our array
            dp[i] = min;

            //increase the exponent based on our min
            if (dp[i] == addTwo) {
                numTwos++;
            }
            if (dp[i] == addThree) {
                numThrees++;
            }
            if (dp[i] == addFive){
                numFives++;
            }



        }

        return dp[n - 1];
    }

}
