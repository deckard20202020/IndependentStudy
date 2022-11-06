package DoorDash;

public class CalculateDifferenceValue {
    public static void main(String[] args) {

        //How should I do this one???

        String firstString = "HACKERRANK";
//        String secondString = "HACKERMAN";
        String secondString = "LACKERRAND";

        int answer = findDifferenceValue(firstString, secondString);
        System.out.println(answer);
    }

    private static int findDifferenceValue(String firstString, String secondString) {
        int answer = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int n = firstString.length();
        int m = secondString.length();

        int[] maxPrefix = new int[n];
        int[] maxSuffix = new int[n];

        // calculate max prefix of secondString in firstString
        // maxPrefix[i] holds the index of the rightmost character in secondString tht doesn't match in firstString (as a subsequence)
        int p = 0;
        for(int i=0; i<n; i++){
            if(p < m && firstString.charAt(i) == secondString.charAt(p)){
                p++;
            }
            maxPrefix[i] = p;
        }

        // calculate max suffix of secondString in firstString
        // maxSuffix[i] holds the index of the leftmost character in secondString that doesn't match in firstString (as a subsequence)
        p = m-1;
        for(int i=n-1; i>=0; i--){
            if(p >= 0 && firstString.charAt(i) == secondString.charAt(p)){
                p--;
            }
            maxSuffix[i] = p;
        }

        // now that we have the maxPrefixes and maxSuffixes, we just need to iterate over the firstString
        // and imagine a 'splitter' between every two indices, so that to the left of the splitter we want to imagine the maxPrefix
        // of the second string and to the right of the splitter we want to imagine the maxSuffix of the secondString
        for(int i=0; i<n-1; i++){
            answer = Math.min(answer, Math.max(0, maxSuffix[i+1] - maxPrefix[i] + 1));
        }

        // here you can imagine the splitter to be at (1) rightBefore the first character in firstString (hence, maxSuffix[0]+1)
        // and (2) right after the last character in firstString (hence, maxPrefix[i-1])
        answer = Math.min(answer, Math.min(maxSuffix[0]+1, m - maxPrefix[n-1]));

        return answer;
    }

}
