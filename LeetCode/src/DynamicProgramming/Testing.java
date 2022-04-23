package DynamicProgramming;

import java.util.ArrayList;

public class Testing {
    public static void main (String[] args) {

        String s = "abc";

        int answer = countSubstrings(s);
        System.out.println(answer);
    }

    private static int countSubstrings(String s) {

        //base case
        if (s.length() == 1) {
            return 1;
        }

       //I don't think we need dynamic programming to solve this problem
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            //check palindromes of odd length
            count = count + exAroundCenter(s, i, i);
            //check palindroms of even length
            count = count + exAroundCenter(s, i, i+1);
        }

        return count;
    }

    private static int exAroundCenter(String s, int low, int high) {
        int count = 0;

        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt((high))) {
            count++;
            low--;
            high++;
        }

        return count;
    }
}
