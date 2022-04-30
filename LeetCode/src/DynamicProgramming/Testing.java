package DynamicProgramming;

import java.util.ArrayList;

public class Testing {
    public static void main (String[] args) {

        int[] coins = {1,2,5};
        int amount = 11;
        //3

//        int[] coins = {2};
//        int amount = 3;
//        //-1
//
//        int[]coins = {1};
//        int amount = 0;
//        //0

//        int[] coins = {2,5,10,1};
//        int amount = 27;
//        //4

        int answer = coinChange(coins, amount);
        System.out.println(answer);
    }

    private static int coinChange(int[] coins, int amount) {

        //create array to store our min values
        int[] minValues = new int[amount + 1];

        //scroll along the totals
        //start at 1 since the number of coins needed to make total of 0 is 0
        for (int i = 1; i <= amount; i ++) {
            //set the min to max integer value
            int min = Integer.MAX_VALUE;
            //scroll along the coin array
            for (int j = 0; j < coins.length; j ++) {
                //if the total - coin >=0 and
                //the min value of the array at total - our coin we are currently looking at
                //is not the max value
                if (i - coins[j] >= 0 && minValues[i - coins[j]] != Integer.MAX_VALUE) {
                    //update the min
                    //should be the minimum of the current min and one more than the minimum stored in table at
                    min = Math.min(min, minValues[i - coins[j]] + 1);
                }
            }
            minValues[i] = min;
        }
        if (minValues[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return minValues[amount];
    }

}
