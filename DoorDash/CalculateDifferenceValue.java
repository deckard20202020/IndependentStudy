package DoorDash;

public class CalculateDifferenceValue {
    public static void main(String[] args) {

        //How should I do this one???

        String firstString = "HACKERRANK";
        String secondString = "HACKERMAN";

        int answer = findDifferenceValue(firstString, secondString);
        System.out.println(answer);
    }

    private static int findDifferenceValue(String firstString, String secondString) {

        int answer = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

//        I think we can solve it in O(n):
//        for every i in firstString[] find the maximum prefix of secondString[] that appears as a subsequence to the left of i,
//        and the maximum suffix of secondString[] that appears as a subsequence to the right of i.
//        call them maxPrefix[i] and maxSuffix[i]
//        Then to get the answer, you would take the min(ans, max(0, maxSuffix[i] - maxPrefix[i]))
//        just the minimum difference over all i
//        wait no this is actually min(ans, max(0, secontString.length - maxSuffix[i] - maxPrefix[i]))

        for (int i = 0; i < firstString.length(); i++) {
            int maxPost = 0;
            int maxPre = 0;
            //find max prefix of secondString that appears as a subsequence to the left of i
            for (int j = 0; j < i; j++) {
                maxPre = maxPrefix(firstString, secondString, i);
            }

            //find max suffix of secondString that appears as a subsequence to the right of i
            for (int k = i; k < secondString.length(); k++) {
                maxPost = maxPostfix(firstString, secondString, i);
            }

            answer = Math.min(answer, Math.max(0, maxPost - maxPre));
//            answer = Math.min(answer, Math.max(0, secondString.length() - maxPost - maxPre));
        }


            return answer + 1;
//        return max - min + 1;
    }

    static int maxPrefix(String s, String t, int index) {
        int count = 0;

        // Iterating string T.
        for (int i = 0; i < index; i++)
        {
            // If end of string S.
            if (count == s.length())
                break;

            // If character match,
            // increment counter.
            if (t.charAt(i) == s.charAt(count))
                count++;
        }

        return count;
    }

    static int maxPostfix(String s, String t, int index) {
        int count = 0;

        // Iterating string T.
        for (int i = index; i < t.length(); i++)
        {
            // If end of string S.
            if (count == s.length())
                break;

            // If character match,
            // increment counter.
            if (t.charAt(i) == s.charAt(count))
                count++;
        }

        return count;
    }


}
