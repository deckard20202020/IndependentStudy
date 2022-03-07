package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Testing {
    public static void main (String[] args) {
        String s = "";
        String t = "ahbgdc";

        boolean answer = isSubsequence(s,t);

        System.out.println(answer);
    }

    private static boolean isSubsequence(String s, String t) {

        //edge cases
        if ( t.length() == 0 || s.length() > t.length()) {
            return false;
        }

        //second edge case
        //we know length of t is greater than 0
        if (s.length() == 0) {
            return true;
        }

        int sPointer = 0;
        int tPointer = 0;

        //we will iterate over s
        while (tPointer < t.length()) {

            //if we have found a match
            if (s.charAt(sPointer) == t.charAt(tPointer)) {

                //check to see if we are at the end of s
                if (sPointer == s.length() -1) {
                    return true;
                }

                //Otherwise increase the sPointer
                sPointer++;

            }

            //increase the t pointer
            tPointer++;

        }

        //if we haven't found a match
        return false;
    }


}
