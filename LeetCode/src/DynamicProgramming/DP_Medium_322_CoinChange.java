package DynamicProgramming;

public class DP_Medium_322_CoinChange {
    public int coinChange(int[] coins, int amount) {

        //this should be a dynammic programming

        //our dp array rows = coins, columns = total
        int[][] dp = new int[coins.length][amount + 1];

        //initialize our array
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = j;
        }

        //now we will scroll through the array and enter the values
        for (int row = 1; row < coins.length; row++) {
            for (int col = 0; col <= amount; ) {
                //min of (square above) and (1+square in same row - value of coin)
                dp[row][col] = Math.min(dp[row-1][col], 1 + dp[row][col-coins[col]]);
            }
        }

        //we will want the bottom right value
        return dp[coins.length-1][amount];

    }
}
