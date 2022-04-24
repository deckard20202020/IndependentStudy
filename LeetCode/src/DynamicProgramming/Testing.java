package DynamicProgramming;

import java.util.ArrayList;

public class Testing {
    public static void main (String[] args) {

        int[] coins = {2};
        int amount = 3;

        int answer = coinChange(coins, amount);
        System.out.println(answer);
    }

    private static int coinChange(int[] coins, int amount) {

        //this should be a dynammic programming

        //check base case
        if(amount == 0) {
            return 0;
        }

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
            for (int col = 1; col <= amount; col++ ) {
                //min of (square above) and (1+square in same row - value of coin)
                if(col - coins[row] < 0) {
                    dp[row][col] = dp[row-1][col];
                } else {
                    dp[row][col] = Math.min(dp[row-1][col], 1 + dp[row][col-coins[row]]);
                }

            }
        }

        //we will want the bottom right value
        return dp[coins.length-1][amount];
    }

}
