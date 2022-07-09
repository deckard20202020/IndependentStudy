package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class DP_Medium_91_DecodeWays {
    public static void main(String[] args) {

        String s = "226";
        int answer = numDecodings(s);
        System.out.println(answer);
    }

    private static int numDecodings(String s) {

        //O(n) time
        //O(n) space

        //base case
        if(s == null) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        //empty string can only be decoded as an empty string
        dp[0] = 1;
        //initialize the dp for first char in string
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }

        //scroll through our array
        for (int i = 2; i < dp.length; i++) {
            //if the char is 0 we can't decode it
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            //check to see if two digit decode is possible
            int temp = Integer.valueOf(s.substring(i - 2, i));
            if(temp >= 10 && temp <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[dp.length - 1];

    }
}
