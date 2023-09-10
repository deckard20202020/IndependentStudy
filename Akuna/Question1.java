package Akuna;

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {

        int n = 5;
        int k = 7;
        int[][] plans= {{1,3,5,2},{1,4,5,3},{2,5,10,1}};

        int answer = minCost(n, k, plans);
        System.out.println(answer);
    }

    private static int minCost(int n, int k, int[][] plans) {

        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int[] plan : plans) {
                int l = plan[0];
                int r = plan[1];
                int cores = plan[2];
                int cost = plan[3];

                if (i >= cores && i >= l && i <= r) {
                    dp[i] = Math.min(dp[i], dp[i - cores] + cost);
                }
            }
        }

        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];

    }


}
