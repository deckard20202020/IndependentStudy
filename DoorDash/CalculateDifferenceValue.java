package DoorDash;

public class CalculateDifferenceValue {
    public static void main(String[] args) {

        //How should I do this one???

        String firstString = "HACKERRANK";
        String secondString = "HACKERMAN";
//        String secondString = "LACKERRAND";

        int answer = findDifferenceValue(firstString, secondString);
        System.out.println(answer);
    }

    private static int findDifferenceValue(String firstString, String secondString) {

        int answer = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        for (int i = 0; i < firstString.length(); i++) {
            int maxPost = 0;
            int maxPre = 0;
            //find max prefix of secondString that appears as a subsequence to the left of i
            maxPre = maxPrefix(firstString, secondString, i);

            //find max suffix of secondString that appears as a subsequence to the right of i
            maxPost = maxPostfix(firstString, secondString, i);

//            answer = Math.min(answer, Math.max(0, maxPost - maxPre));
            answer = Math.min(answer, Math.max(0, secondString.length() - maxPost - maxPre));
        }


            return answer + 1;
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
