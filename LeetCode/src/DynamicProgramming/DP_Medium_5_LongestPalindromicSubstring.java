package DynamicProgramming;

public class DP_Medium_5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        String answer = "";

        if (s.length() == 1) {
            Character c = s.charAt(0);
            String C = c.toString();
            answer = answer.concat(C);
            return answer;
        }

        //start of palindrome
        int start = 0;
        //end of palindrome
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            //we will expand around the centers
            //call it once for single characters
            int l1 = expandAroundCenter(s, i, i);
            //call it again for double characters
            int l2 = expandAroundCenter(s, i, i+1);

            //take the greater of the two values above
            int max = Math.max(l1, l2);

            //if we have found a greater value
            if (max > end - start) {
                start = i - (max-1)/2;
                end = i + max/2;
            }
        }

        //substring method includes the first number
        //doesn't include the last
        return s.substring(start, end + 1);

    }

    private static int expandAroundCenter(String s, int left, int right) {

        int L = left;
        int R = right;

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L = L-1;
            R = R + 1;

        }
        return R-L -1;
    }
}
