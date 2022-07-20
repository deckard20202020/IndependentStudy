package DynamicProgramming;

public class DP_Medium_343_IntegerBreak {
    public static void main(String[] args) {
        int n = 2;
        int answer = integerBreak(n);
        System.out.println(answer);
    }

    private static int integerBreak(int n) {

        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i < dp.length; i++) {
            int max_res = 1;
            for (int right = 2; right < i; right++) {
                int left = i - right;
                max_res = Math.max(max_res, Math.max(left * right, left * dp[right]));
            }
            dp[i] = max_res;
        }

        return dp[n];

    }
}
