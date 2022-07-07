package DynamicProgramming;

import java.util.Arrays;

public class DP_Medium_309_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        //int[] prices = {1,2,3,0,2};
        int[] prices = {1,2,4};
        int answer = maxProfit(prices);
        System.out.println(answer);
    }

    private static int maxProfit(int[] prices) {

        //idea
        //we will use a 2D array for the dp
        //we will find the max of all the leaf nodes of our decision tree
            //choices are buy, sell, cooldown
        //our two possible states are buying or selling.
            //represented as a boolean 0 or 1 in the 2D array
        //if buy, increase the index by 1
        //if sell, increase the index by 2 for cooldown


        int n=prices.length;
        int[][] dp=new int[2][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }

        return helper(0,prices,1,dp);


    }

    private static int helper(int ind,int[] prices,int buy,int[][] dp){

        if(ind>=prices.length){
            return 0;
        }
        if(dp[buy][ind]!=-1){
            return dp[buy][ind];
        }
        if(buy==1){

            return dp[buy][ind]= Math.max(-prices[ind]+helper(ind+1,prices,0,dp),
                    0+helper(ind+1,prices,1,dp)
            );
        }else{

            return dp[buy][ind]= Math.max(prices[ind]+helper(ind+2,prices,1,dp),0+helper(ind+1,prices,0,dp));
        }

    }

}
