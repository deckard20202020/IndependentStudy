package DynamicProgramming;

public class DP_Medium_322_CoinChange {
    public static void main(String[] args)  {
//        int[] coins = {1,2,5};
//        int amount = 11;

        int[] coins = {2};
        int amount = 3;

        int answer = coinChange(coins, amount);
        System.out.println(answer);

    }

    private static int coinChange(int[] coins, int amount) {

        //make an array for our dp
        int[] dp = new int[amount + 1];
        //this is initialized to all 0's so we don't need to set the first 0

        //scroll through the dp array
        //the index of the dp array will be the total we are tyring to make
        //we can start at 1 because it takes 0 coins to make a total of 0
        for (int i = 1; i < dp.length; i++) {
            //initialize the min amount
            int min = Integer.MAX_VALUE;
            //scroll through our list of coins
            for (int j = 0; j < coins.length; j++) {
                //check 1: the value of our coin is less than
                //the total we are trying to make
                if (i - coins[j] >= 0) {
                    //check 2: we were able to make change for the total
                    //we are trying to make - the value of the coin we are on
                    if(dp[i - coins[j]] != Integer.MAX_VALUE) {
                        //update our min
                        min = Math.min(min, dp[i - coins[j]] +1);
                    }
                }
            }
            //update our dp array
            dp[i] = min;
        }

        //make sure we were able to make the change
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        //return our answer
        return dp[amount];
    }
}
