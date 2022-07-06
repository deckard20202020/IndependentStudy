package DynamicProgramming;

public class DP_Medium_1014_BestSightseeingPair {
    public static void main(String[] args) {
        //int[] values = {8,1,5,2,6};
        int[] values = {3,7,2,3};
        int answer = maxScoreSightseeingPair(values);
        System.out.println(answer);
    }

    private static int maxScoreSightseeingPair(int[] values) {

        //base case
        if (values.length == 2) {
            return values[0] + values[1] - 1;
        }

        //initialize our dp array
        int[] dp = new int[values.length];
        dp[0] = values[0] + values[1] - 1;

        for (int i = 2; i < values.length; i++) {
            int current = values[i] + values[i - 1] - 1;
            int dynamic = dp[i - 2] - 1 - values[i - 1] + values[i];
            dp[i - 1] = Math.max(current, dynamic);
            //dp[i] = Math.max(dp[i - 1] - 1 + values[i], values[i] + values[i - 1] - 1);
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
