package DynamicProgramming;

public class DP_Easy_392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        //should be O(n)-length of S

        //edge cases
        if (s.length() > t.length()) {
            return false;
        }

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
