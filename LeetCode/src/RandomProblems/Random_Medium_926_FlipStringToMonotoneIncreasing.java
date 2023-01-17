package RandomProblems;

public class Random_Medium_926_FlipStringToMonotoneIncreasing {
    public static void main(String[] args) {
//        String s = "00110";
        String s = "10011111110010111011";
        int answer = minFlipsMonoIncr(s);
        System.out.println(answer);
    }

    private static int minFlipsMonoIncr(String s) {

        int m = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++m;
            }
        }
        int ans = m;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ans = Math.min(ans, --m);
            } else {
                ++m;
            }
        }
        return ans;

    }



}
