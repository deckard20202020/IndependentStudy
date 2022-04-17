package LeetCode_Competitions;

public class Problem_1_4_16_22 {
    public static void main(String[] args) {
//        https://leetcode.com/contest/weekly-contest-289/problems/calculate-digit-sum-of-a-string/
//        6070. Calculate Digit Sum of a String

        String s = "11111222223";
        int k = 3;

        String answer = digitSum(s,k);
        System.out.println(answer);


    }

    private static String digitSum(String s, int k) {

        while (k < s.length()) {
            int i = 0;
            String newSubstring = "";

            //divide the string into small legths
            while (i < s.length()) {
                int total = 0;
                String substring = "";

                if (i+k+1 > s.length()) {
                    substring = s.substring(i, s.length());
                } else {
                    substring = s.substring(i, i+k);
                }

                //take total of the substring
                for (int n = 0; n < substring.length(); n++) {
                    int single = Integer.parseInt(substring.substring(n,n+1));
                    total = total + single;
                }

                //turn the total into into a string
                String totalString = String.valueOf(total);

                newSubstring= newSubstring + totalString;
                i = i + k;

            }

            s = newSubstring;



        }

        return s;
    }
}
